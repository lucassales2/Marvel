package com.example.lucassales.marvel;


import com.example.lucassales.marvel.inject.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by lucassales on 27/11/2017.
 */

public class MarvelApplication extends DaggerApplication {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    protected AndroidInjector<MarvelApplication> applicationInjector() {
        return DaggerApplicationComponent.builder()
                .create(this);
    }

}
