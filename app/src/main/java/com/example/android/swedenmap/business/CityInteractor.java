package com.example.android.swedenmap.business;

import com.example.android.swedenmap.data.City;
import com.example.android.swedenmap.data.CityRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CityInteractor {

    private final CityRepository cityRepository;
    private List<String> citiesNames;

    @Inject
    public CityInteractor(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
        this.citiesNames = new ArrayList<>();
    }

    public List<City> getData() {
        return cityRepository.getData();
    }
}
