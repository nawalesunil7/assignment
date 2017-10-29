package com.listeners;

import com.model.LocationData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/sample.json")
    Call<ArrayList<LocationData>> doGetListLocations();
}
