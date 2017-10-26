package com.example.android.swedenmap.data.repository;

import com.example.android.swedenmap.data.repository.threads.CityFileAsyncTask;
import com.example.android.swedenmap.ui.home.CityAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

public class CityRepository {


    private ArrayList<City> citiesData;

    @Inject
    public CityRepository() {
        citiesData = new ArrayList<>();
    }

    public ArrayList<City> getData() {

        CityFileAsyncTask cityFileAsyncTask = new CityFileAsyncTask();
        try {
           citiesData.addAll(cityFileAsyncTask.execute().get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return citiesData;
    }


}
