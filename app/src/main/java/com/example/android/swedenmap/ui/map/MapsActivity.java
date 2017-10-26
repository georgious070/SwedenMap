package com.example.android.swedenmap.ui.map;

import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.location.Location;
import android.support.annotation.NonNull;
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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final String KEY = "key_cities";

    private GoogleMap mMap;

    public static Intent getIntent(Context context, List<String> cityName) {
        Intent intent = new Intent(context, MapsActivity.class);
        intent.putExtra(KEY, (Serializable) cityName);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        List<String> cityNames = getIntent().getStringArrayListExtra(KEY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng helsinbourg = new LatLng(56.03, 12.43);
        mMap.addMarker(new MarkerOptions().
                position(helsinbourg).
                title("Helsinbourg").
                draggable(false));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(helsinbourg));

        LatLng malmo = new LatLng(55.36, 13.02);
        mMap.addMarker(new MarkerOptions().
                position(malmo).
                title("Malmo").
                draggable(false));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(malmo));
        List<LatLng> markersLatLng = new ArrayList<>();
        markersLatLng.add(malmo);
        markersLatLng.add(helsinbourg);

        googleMap.setOnCameraMoveCanceledListener(new GoogleMap.OnCameraMoveCanceledListener() {
            @Override
            public void onCameraMoveCanceled() {
                findNeighborCirtToCenterMarker(markersLatLng, googleMap.getCameraPosition().target);

            }
        });
    }

    void findNeighborCirtToCenterMarker(List<LatLng> markersLatLng, LatLng cameraPosition) {
        double minDistance = SphericalUtil.computeDistanceBetween(markersLatLng.get(0), cameraPosition);
        for (int i = 0; i < markersLatLng.size(); i++) {
            if (minDistance > SphericalUtil.computeDistanceBetween(markersLatLng.get(i), cameraPosition)) {
                minDistance = SphericalUtil.computeDistanceBetween(markersLatLng.get(i), cameraPosition);
            }
        }

        Toast.makeText(this, "Min Distance to " + minDistance/1000, Toast.LENGTH_SHORT).show();
    }
}
