package com.example.android.swedenmap.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.swedenmap.R;
import com.example.android.swedenmap.ui.base.BaseActivity;

public class CityActivity extends BaseActivity implements CityView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
