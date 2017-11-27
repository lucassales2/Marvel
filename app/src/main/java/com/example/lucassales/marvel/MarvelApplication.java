package com.example.lucassales.marvel;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by lucassales on 27/11/2017.
 */

public class MarvelApplication extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return null;
    }
}
