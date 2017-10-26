package com.example.android.swedenmap.di.module;

import android.content.Context;

import com.example.android.swedenmap.App;
import com.example.android.swedenmap.di.component.AppComponent;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Context context;

    public AppModule(App context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }
}


