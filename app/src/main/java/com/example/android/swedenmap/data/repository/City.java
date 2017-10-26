package com.example.android.swedenmap.data.repository;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class City implements Parcelable, Serializable {

    public transient Context context;

    private String name;
    private double lat;
    private double lng;

    public City(String name, double lat, double lng){
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    protected City(Parcel in) {
        name = in.readString();
        lat = in.readDouble();
        lng = in.readDouble();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public String getName() {
        return name;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeDouble(lat);
        parcel.writeDouble(lng);
    }
}
