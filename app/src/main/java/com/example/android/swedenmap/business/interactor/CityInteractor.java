package com.example.android.swedenmap.business.interactor;

import com.example.android.swedenmap.App;
import com.example.android.swedenmap.data.repository.City;
import com.example.android.swedenmap.data.repository.CityRepository;

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

    public List<String> getData() {
        return getCitiesNames();
    }

    public List<String> getCitiesNames() {
        List<City> cities = cityRepository.getData();
        for (int i = 0; i < cities.size(); i++) {
            citiesNames.add(cities.get(i).getName());
        }
        return citiesNames;
    }
}
