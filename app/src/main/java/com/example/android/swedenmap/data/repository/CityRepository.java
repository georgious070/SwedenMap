package com.example.android.swedenmap.data.repository;

import com.example.android.swedenmap.data.repository.threads.CityFileAsyncTask;
import com.example.android.swedenmap.ui.home.CityAdapter;

import java.util.ArrayList;

public class CityRepository {

    private ArrayList<ArrayList<Object>> cities;

    public CityRepository(){

    }

    void getCities(){
        CityFileAsyncTask cityFileAsyncTask = new CityFileAsyncTask();
        cityFileAsyncTask.execute();
    }
}
