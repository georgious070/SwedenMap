package com.example.android.swedenmap.data.repository;

import com.example.android.swedenmap.data.repository.threads.CityFileAsyncTask;
import com.example.android.swedenmap.ui.home.CityAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

public class CityRepository {

    private ArrayList<City> listOfcities;
    private ArrayList<City> citiesData;

    @Inject
    public CityRepository() {
        listOfcities = new ArrayList<>();
        citiesData = new ArrayList<>();
    }

    public ArrayList<City> getData() {
        if (listOfcities.size() == 0) {
            setCities();
        }

        CityFileAsyncTask cityFileAsyncTask = new CityFileAsyncTask();
        City[] cities = new City[getListOfcities().size()];
        for(int i = 0; i<getListOfcities().size(); i++){
            cities[i] = getListOfcities().get(i);
        }
        try {
            cityFileAsyncTask.execute(cities).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return citiesData;
    }

    private void setCities() {

        listOfcities.add(new City("Helsinbourg", 56.03, 12.43));
        listOfcities.add(new City("Malmo", 55.36, 13.02));
        listOfcities.add(new City("Ystad", 55.25, 13.50));
        listOfcities.add(new City("Trelleborg", 55.22, 13.09));
        listOfcities.add(new City("Lund", 55.42, 13.09));
    }

    private ArrayList<City> getListOfcities() {
        return listOfcities;
    }
}
