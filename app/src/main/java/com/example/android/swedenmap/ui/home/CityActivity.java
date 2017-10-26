package com.example.android.swedenmap.ui.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.android.swedenmap.R;
import com.example.android.swedenmap.data.repository.City;
import com.example.android.swedenmap.ui.base.BaseActivity;
import com.example.android.swedenmap.ui.map.MapsActivity;

import java.util.ArrayList;
import java.util.List;

public class CityActivity extends BaseActivity implements CityView, CityAdapter.OnCityClickListener {

    @InjectPresenter
    CityPresenter cityPresenter;
    private RecyclerView recyclerView;
    private CityAdapter cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_cities);
        cityAdapter = new CityAdapter(this);
        recyclerView.setAdapter(cityAdapter);
    }

    @Override
    public void showData(List<String> cityList) {
        cityAdapter.setData(cityList);
    }

    @Override
    public void onClickCity(List<String> cities) {
        startActivity(MapsActivity.getIntent(this, cities));
    }
}
