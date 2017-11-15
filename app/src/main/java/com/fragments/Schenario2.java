package com.fragments;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.adapter.SpinnerRecyclerAdapter;
import com.listeners.APIInterface;
import com.listeners.onItemClickedListener;
import com.model.LocationData;
import com.roshanitejas.testassignment.utils;
import com.sunilnawale.testassignment.R;
import com.sunilnawale.testassignment.databinding.FragmentScenario1Binding;
import com.sunilnawale.testassignment.databinding.FragmentScenario2Binding;

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Schenario2 extends BaseFragment implements AdapterView.OnItemSelectedListener {
    LocationData Selectedlocation = null;
    ArrayList<LocationData> locationListdata = null;
    FragmentScenario2Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_scenario2, container, false);
        binding.spLocation.setOnItemSelectedListener(this);
        if (utils.isInternetOn(getActivity())) {
            APIInterface apiInterface = utils.getClient().create(APIInterface.class);
            Call call = apiInterface.doGetListLocations();
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.body() != null) {
                        locationListdata = (ArrayList<LocationData>) response.body();
                        if (locationListdata != null) {
                            binding.spLocation.setAdapter(new SpinnerRecyclerAdapter(locationListdata));
                        }
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    //error
                }
            });
        } else {
            showToast(getActivity(), "No internet available.");
        }
        binding.btnNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (utils.isInternetOn(getActivity())) {
                    if (Selectedlocation != null && Selectedlocation.getLocationDetails() != null) {
                        String uri = String.format(Locale.ENGLISH, "geo:%f,%f?z=%d&q=%f,%f (%s)",
                                Double.parseDouble(Selectedlocation.getLocationDetails().getLatitude()), Double.parseDouble(Selectedlocation.getLocationDetails().getLongitude()), 100, Double.parseDouble(Selectedlocation.getLocationDetails().getLatitude()), Double.parseDouble(Selectedlocation.getLocationDetails().getLongitude()), Selectedlocation.getName());
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                        if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(mapIntent);
                        } else {
                            showToast(getActivity(), "Please install google map.");
                        }

                    }
                } else {
                    showToast(getActivity(), "No internet available.");
                }
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (locationListdata != null) {
            listener.getSelectedLocationDetails(locationListdata.get(position));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    onItemClickedListener listener = new onItemClickedListener() {
        @Override
        public void getSelectedItem(String item) {
            //used in 1st scenario
        }

        @Override
        public void getSelectedLocationDetails(LocationData location) {
            Selectedlocation = location;
            binding.txtCar.setText((location.getCentrailsDetails() != null && !TextUtils.isEmpty(location.getCentrailsDetails().getCar())) ? ("Car - " + location.getCentrailsDetails().getCar()) : ("Car - "));
            binding.txtTrain.setText((location.getCentrailsDetails() != null && !TextUtils.isEmpty(location.getCentrailsDetails().getTrain())) ? ("Train - " + location.getCentrailsDetails().getTrain()) : "Train - ");
        }
    };

}
