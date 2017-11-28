package com.example.lucassales.marvel.data.network;

import com.example.lucassales.marvel.BuildConfig;
import com.example.lucassales.marvel.data.network.response.GetComicsResponse;
import com.google.gson.Gson;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.TestScheduler;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lucassales on 28/11/2017.
 */
public class ApiManagerImplTest {

    ApiManager apiManager;

    @Before
    public void start() {

        MarvelApiService marvelApiService = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MarvelApiService.class);
        apiManager = new ApiManagerImpl(marvelApiService, BuildConfig.PUBLIC_KEY, BuildConfig.PRIVATE_KEY);
    }

    @Test
    public void getComicBooks() throws Exception {

        Single<GetComicsResponse> comicBooks = apiManager.getComicBooks();
        GetComicsResponse getComicsResponse = comicBooks.blockingGet();

        Assert.assertNotNull(getComicsResponse.getData());

    }

}