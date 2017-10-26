package com.example.android.swedenmap.ui.map;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.android.swedenmap.R;
import com.example.android.swedenmap.data.repository.City;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String KEY = "key_cities";
    private List<City> cities;
    private List<LatLng> latLngArrayList;
    private String nameOfNearestCity;

    private GoogleMap mMap;

    public static Intent getIntent(Context context, List<City> cityName) {
        Intent intent = new Intent(context, MapsActivity.class);
        intent.putParcelableArrayListExtra(KEY, (ArrayList<? extends Parcelable>) cityName);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        latLngArrayList = new ArrayList<>();
        cities = new ArrayList<>();
        cities = getIntent().getParcelableArrayListExtra(KEY);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        for (int i = 0; i < cities.size(); i++) {
            latLngArrayList.add(new LatLng(cities.get(i).getLat(), cities.get(i).getLng()));

            mMap.addMarker(new MarkerOptions()
                    .position(latLngArrayList.get(i))
                    .title(cities.get(i).getName())
                    .draggable(false));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLngArrayList.get(i)));
        }

        googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
            @Override
            public void onCameraIdle() {
                findNeighborCirtToCenterMarker(latLngArrayList, googleMap.getCameraPosition().target);
            }
        });
    }

    public void findNeighborCirtToCenterMarker(List<LatLng> markersLatLng, LatLng cameraPosition) {
        double minDistance = SphericalUtil.computeDistanceBetween(markersLatLng.get(0), cameraPosition);
        nameOfNearestCity = cities.get(0).getName();
        for (int i = 0; i < markersLatLng.size(); i++) {
            if (minDistance > SphericalUtil.computeDistanceBetween(markersLatLng.get(i), cameraPosition)) {
                minDistance = SphericalUtil.computeDistanceBetween(markersLatLng.get(i), cameraPosition);
                nameOfNearestCity = cities.get(i).getName();
            }
        }

        String distanceTwoDecimalPlace = new DecimalFormat("#0.00").format(minDistance / 1000);
        Toast.makeText(this,
                "Distance to nearest " + nameOfNearestCity + " = " + distanceTwoDecimalPlace + "km",
                Toast.LENGTH_SHORT)
                .show();
    }
}
