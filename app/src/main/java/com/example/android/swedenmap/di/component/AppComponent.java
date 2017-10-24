package com.example.android.swedenmap.di.component;

import com.example.android.swedenmap.App;
import com.example.android.swedenmap.di.module.AppModule;
import com.example.android.swedenmap.ui.home.CityPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject (App app);
    void inject (CityPresenter cityPresenter);
}
