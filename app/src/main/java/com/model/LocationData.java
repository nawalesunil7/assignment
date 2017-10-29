package com.model;

import com.google.gson.annotations.SerializedName;


public class LocationData {
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

    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("fromcentral")
    fromcentral centrailsDetails=null;
    @SerializedName("location")
    location locationDetails=null;
    public class fromcentral{
        @SerializedName("car")
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

        @SerializedName("train")
        String train;
    }

    public class location{
        @SerializedName("latitude")
        String latitude;
        @SerializedName("longitude")
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
