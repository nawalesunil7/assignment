package com.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class LocationData implements Serializable{
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public fromcentral getCentrailsDetails() {
        return centrailsDetails;
    }

    public void setCentrailsDetails(fromcentral centrailsDetails) {
        this.centrailsDetails = centrailsDetails;
    }

    public location getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(location locationDetails) {
        this.locationDetails = locationDetails;
    }

    int id;
    String name;
    @SerializedName("fromcentral")
    fromcentral centrailsDetails;
    @SerializedName("location")
    location locationDetails;

    public class fromcentral{
        String car;

        public String getCar() {
            return car;
        }

        public void setCar(String car) {
            this.car = car;
        }

        public String getTrain() {
            return train;
        }

        public void setTrain(String train) {
            this.train = train;
        }

        String train;
    }

    public class location{

        String latitude;

        String longitude;

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
    }

}
