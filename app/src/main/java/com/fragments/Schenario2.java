package com.fragments;

import android.content.Intent;
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

import java.util.ArrayList;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Schenario2 extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    View v = null;
    LocationData Selectedlocation = null;
    ArrayList<LocationData> locationListdata = null;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_scenario2, container, false);
        final Spinner sp_location = (Spinner) v.findViewById(R.id.sp_location);
        sp_location.setOnItemSelectedListener(this);
        v.findViewById(R.id.btn_navigate).setOnClickListener(this);
        if (utils.isInternetOn(getActivity())) {
            APIInterface apiInterface = utils.getClient().create(APIInterface.class);
            Call call = apiInterface.doGetListLocations();
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                    if (response.body() != null) {
                        locationListdata = (ArrayList<LocationData>) response.body();
                        if (locationListdata != null) {
                            sp_location.setAdapter(new SpinnerRecyclerAdapter(locationListdata));
                        }
                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    //error
                }
            });
        } else {
            utils.showToast(getActivity(), "No internet available.");
        }
        return v;
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
            TextView txt_car = (TextView) v.findViewById(R.id.txt_car);

            if (location.getCentrailsDetails() != null && !TextUtils.isEmpty(location.getCentrailsDetails().getCar()))
                txt_car.setText("Car - " + location.getCentrailsDetails().getCar());
            else
                txt_car.setText("Car - ");
            TextView txt_train = (TextView) v.findViewById(R.id.txt_train);
            if (location.getCentrailsDetails() != null && !TextUtils.isEmpty(location.getCentrailsDetails().getTrain()))
                txt_train.setText("Train - " + location.getCentrailsDetails().getTrain());
            else
                txt_train.setText("Train - ");
        }
    };

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_navigate) {
            if (utils.isInternetOn(getActivity())) {
                if (Selectedlocation != null && Selectedlocation.getLocationDetails() != null) {
                    String uri = String.format(Locale.ENGLISH, "geo:%f,%f?z=%d&q=%f,%f (%s)",
                            Double.parseDouble(Selectedlocation.getLocationDetails().getLatitude()),  Double.parseDouble(Selectedlocation.getLocationDetails().getLongitude()), 100, Double.parseDouble(Selectedlocation.getLocationDetails().getLatitude()),   Double.parseDouble(Selectedlocation.getLocationDetails().getLongitude()), Selectedlocation.getName());
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                    if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(mapIntent);
                    }else{
                        utils.showToast(getActivity(), "Please install google map.");
                    }

                }
            } else {
                utils.showToast(getActivity(), "No internet available.");
            }
        }
    }
}
