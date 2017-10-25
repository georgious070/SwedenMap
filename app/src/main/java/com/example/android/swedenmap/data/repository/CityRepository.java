package com.example.android.swedenmap.data.repository;

import com.example.android.swedenmap.data.repository.threads.CityFileAsyncTask;
import com.example.android.swedenmap.ui.home.CityAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class CityRepository {

    private ArrayList<ArrayList<Object>> listOfcities;

    public CityRepository() {

    }

    void getData() {
        if(listOfcities.size() == 0){
            setCities();
        }


        CityFileAsyncTask cityFileAsyncTask = new CityFileAsyncTask();
        cityFileAsyncTask.execute(getListOfcities());

    }

    public final void setCities() {
        ArrayList<Object> helsinbourg = new ArrayList<>(Arrays.asList("Helsinbourg", 56.03, 12.43));
        ArrayList<Object> malmo = new ArrayList<>(Arrays.asList("Malmo", 55.36, 13.02));
        ArrayList<Object> ystad = new ArrayList<>(Arrays.asList("Ystad", 55.25, 13.50));
        ArrayList<Object> trelleborg = new ArrayList<>(Arrays.asList("Trelleborg", 55.22, 13.09));
        ArrayList<Object> lund = new ArrayList<>(Arrays.asList("Lund", 55.42, 13.09));

        listOfcities.add(helsinbourg);
        listOfcities.add(malmo);
        listOfcities.add(ystad);
        listOfcities.add(trelleborg);
        listOfcities.add(lund);
    }

    public ArrayList<ArrayList<Object>> getListOfcities() {
        return listOfcities;
    }
}
