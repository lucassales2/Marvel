package com.example.lucassales.marvel.di.module;

import com.example.lucassales.marvel.BuildConfig;
import com.example.lucassales.marvel.data.network.MarvelApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lucassales on 27/11/2017.
 */

@Module
public class NetworkModule {

    private static final String BASE_URL = "baseUrl";

    @Provides
    @Named(BASE_URL)
    String provideBaseUrl() {
        return BuildConfig.BASE_URL;
    }

    @Provides
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl, OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    MarvelApiService provideMarvelApiService(Retrofit retrofit) {
        return retrofit.create(MarvelApiService.class);
    }

}
