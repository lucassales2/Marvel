package com.example.lucassales.marvel.data.network;

import com.example.lucassales.marvel.data.network.response.GetComicsResponse;
import com.example.lucassales.marvel.inject.NetworkModule;
import com.example.lucassales.marvel.util.Security;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Single;

/**
 * Created by lucassales on 28/11/2017.
 */

public class ApiManagerImpl implements ApiManager {

    private final MarvelApiService apiService;
    private final String publicKey;
    private final String privateKey;

    @Inject
    public ApiManagerImpl(MarvelApiService marvelApiService,
                          @Named(NetworkModule.PUBLIC_KEY) String publicKey,
                          @Named(NetworkModule.PRIVATE_KEY) String privateKey) {
        apiService = marvelApiService;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    @Override
    public Single<GetComicsResponse> getComicBooks() {
        long timeMillis = System.currentTimeMillis();
        return apiService.getComics(publicKey, Security.generateHash(privateKey, publicKey, timeMillis), timeMillis);
    }
}
