package com.example.lucassales.marvel.inject;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.lucassales.marvel.MarvelApplication;
import com.example.lucassales.marvel.data.DataManager;
import com.example.lucassales.marvel.data.DataManagerImpl;
import com.example.lucassales.marvel.data.db.DbManager;
import com.example.lucassales.marvel.data.db.DbManagerImpl;
import com.example.lucassales.marvel.data.db.MarvelRoomDatabase;
import com.example.lucassales.marvel.data.network.ApiManager;
import com.example.lucassales.marvel.data.network.ApiManagerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by lucassales on 27/11/2017.
 */

@Module
public class ApplicationModule {

    @ApplicationContext
    @Provides
    Context provideContext(MarvelApplication application) {
        return application.getApplicationContext();
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Singleton
    @Provides
    DataManager provideDataManager(DataManagerImpl dataManager) {
        return dataManager;
    }

    @Singleton
    @Provides
    ApiManager provideApiManager(ApiManagerImpl apiManager) {
        return apiManager;
    }

    @Provides
    DbManager provideDbManager(DbManagerImpl dbManager) {
        return dbManager;
    }

    @Provides
    @Singleton
    MarvelRoomDatabase provideHelpieDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, MarvelRoomDatabase.class, "com.example.lucassales.marvel.db")
                .build();
    }

}
