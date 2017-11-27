package com.example.lucassales.marvel.di.component;

import com.example.lucassales.marvel.MarvelApplication;
import com.example.lucassales.marvel.di.module.ApplicationModule;
import com.example.lucassales.marvel.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Created by lucassales on 27/11/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent extends AndroidInjector<MarvelApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MarvelApplication> {

    }
}
