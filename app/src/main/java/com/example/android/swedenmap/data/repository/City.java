package com.example.android.swedenmap.data.repository;

import android.content.Context;

import java.io.Serializable;

public class City implements Serializable{

    public transient Context context;

    private String name;
    private double lat;
    private double lng;

    public City(String name, double lat, double lng){
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
