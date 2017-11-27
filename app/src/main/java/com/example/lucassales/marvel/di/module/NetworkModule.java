package com.example.lucassales.marvel.di.module;

import com.example.lucassales.marvel.BuildConfig;
import com.example.lucassales.marvel.data.network.MarvelApiService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by lucassales on 27/11/2017.
 */

@Module
public class NetworkModule {

    public static final String BASE_URL = "baseUrl";

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
    Retrofit provideRetrofit(@Named(BASE_URL) String baseUrl, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    MarvelApiService provideMarvelApiService(Retrofit retrofit) {
        return retrofit.create(MarvelApiService.class);
    }

}
