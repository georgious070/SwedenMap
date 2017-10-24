package com.example.android.swedenmap.ui.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.android.swedenmap.R;
import com.example.android.swedenmap.ui.base.BaseActivity;

import java.util.ArrayList;

public class CityActivity extends BaseActivity implements CityView{

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_cities);
        CityAdapter cityAdapter = new CityAdapter(new ArrayList<String>());
        recyclerView.setAdapter(cityAdapter);
    }

    @Override
    public void showData() {

    }
}
