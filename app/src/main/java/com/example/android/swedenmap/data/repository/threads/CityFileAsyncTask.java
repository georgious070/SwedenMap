package com.example.android.swedenmap.data.repository.threads;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;

import com.example.android.swedenmap.App;
import com.example.android.swedenmap.Utils.Constants;
import com.example.android.swedenmap.data.repository.City;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class CityFileAsyncTask
        extends AsyncTask<City, Void, ArrayList<City>> {

    private File file;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private ArrayList<City> listOfCitiesAndCoordinates;

    @Override
    protected ArrayList<City> doInBackground(City... cities) {

        listOfCitiesAndCoordinates = new ArrayList<>();

        file = new File(App.getApp().getFilesDir(), Constants.FILE_NAME);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileOutputStream = App.getApp().openFileOutput(Constants.FILE_NAME, Context.MODE_WORLD_WRITEABLE);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(cities);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileInputStream = App.getApp().openFileInput(Constants.FILE_NAME);
            objectInputStream = new ObjectInputStream(fileInputStream);
            objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
