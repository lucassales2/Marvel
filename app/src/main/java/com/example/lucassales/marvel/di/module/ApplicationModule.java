package com.example.lucassales.marvel.di.module;

import android.content.Context;

import com.example.lucassales.marvel.MarvelApplication;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lucassales on 27/11/2017.
 */

@Module
public class ApplicationModule {

    @Provides
    Context provideContext(MarvelApplication application) {
        return application.getApplicationContext();
    }
}
