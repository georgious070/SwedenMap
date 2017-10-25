package com.example.android.swedenmap.data.repository.threads;

import android.os.AsyncTask;
import android.widget.ProgressBar;

import com.example.android.swedenmap.App;
import com.example.android.swedenmap.Utils.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CityFileAsyncTask
        extends AsyncTask<ArrayList<ArrayList<Object>>, Void, ArrayList<ArrayList<Object>>> {

    private File file;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private ArrayList<ArrayList<Object>> listOfCitiesAndCoordinates;

    @Override
    protected ArrayList<ArrayList<Object>> doInBackground(ArrayList<ArrayList<Object>>... arrayLists) {

        if (!file.exists()) {
            file = new File(Constants.FILE_NAME);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file.length() == 0) {
            try {
                fileOutputStream = new FileOutputStream(file);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(arrayLists);
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileInputStream = new FileInputStream(file);
            objectInputStream = new ObjectInputStream(fileInputStream);
            listOfCitiesAndCoordinates = (ArrayList<ArrayList<Object>>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listOfCitiesAndCoordinates;
    }
}
