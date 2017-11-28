package com.example.lucassales.marvel.inject;

import com.example.lucassales.marvel.MarvelApplication;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by lucassales on 27/11/2017.
 */

@Singleton
@Component(modules = {NetworkModule.class, ApplicationModule.class, AndroidSupportInjectionModule.class, ActivityBuilder.class})
public interface ApplicationComponent extends AndroidInjector<MarvelApplication> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<MarvelApplication> {
        public abstract ApplicationComponent build();
    }

}
