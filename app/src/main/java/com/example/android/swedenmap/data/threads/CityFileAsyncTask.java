package com.example.android.swedenmap.data.threads;

import android.content.Context;
import android.os.AsyncTask;

import com.example.android.swedenmap.App;
import com.example.android.swedenmap.Utils.Constants;
import com.example.android.swedenmap.data.City;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CityFileAsyncTask
        extends AsyncTask<Void, Void, ArrayList<City>> {

    private File file;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private ArrayList<City> listOfCitiesAndCoordinates;
    private ArrayList<City> listOfcities;

    @Override
    protected ArrayList<City> doInBackground(Void... params) {

        listOfcities = new ArrayList<>();
        listOfCitiesAndCoordinates = new ArrayList<>();
        setCities();

        file = new File(App.getApp().getBaseContext().getFilesDir(), Constants.FILE_NAME);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileOutputStream = App.getApp().getBaseContext().openFileOutput(Constants.FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(getListOfCities());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileInputStream = App.getApp().openFileInput(Constants.FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listOfCitiesAndCoordinates = (ArrayList<City>) (objectInputStream.readObject());
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listOfCitiesAndCoordinates;
    }

    private void setCities() {
        listOfcities.add(new City("Helsinbourg", 56.049254, 12.780285));
        listOfcities.add(new City("Malmo", 55.597194, 13.013744));
        listOfcities.add(new City("Ystad", 55.431463, 13.816900));
        listOfcities.add(new City("Trelleborg", 55.377216, 13.154178));
        listOfcities.add(new City("Lund", 55.713409, 13.195019));
    }

    private ArrayList<City> getListOfCities() {
        return listOfcities;
    }
}
