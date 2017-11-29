package com.example.lucassales.marvel.data.network;

import com.example.lucassales.marvel.data.network.response.GetComicByIdResponse;
import com.example.lucassales.marvel.data.network.response.GetComicCreatorsResponse;
import com.example.lucassales.marvel.data.network.response.GetComicsResponse;
import com.example.lucassales.marvel.inject.NetworkModule;
import com.example.lucassales.marvel.util.Security;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

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
        return Single.just(System.currentTimeMillis())
                .flatMap(new Function<Long, SingleSource<GetComicsResponse>>() {
                    @Override
                    public SingleSource<GetComicsResponse> apply(Long aLong) throws Exception {
                        return apiService.getComics(publicKey, Security.generateHash(privateKey, publicKey, aLong), aLong, 100);
                    }
                });

    }

    @Override
    public Single<GetComicByIdResponse> getComicById(int comicId) {
        return Single.just(comicId)
                .flatMap(new Function<Integer, SingleSource<GetComicByIdResponse>>() {
                    @Override
                    public SingleSource<GetComicByIdResponse> apply(Integer integer) throws Exception {
                        long timeMillis = System.currentTimeMillis();
                        return apiService.getComicById(
                                integer,
                                publicKey,
                                Security.generateHash(privateKey, publicKey, timeMillis),
                                timeMillis
                        );
                    }
                });

    }

    @Override
    public Single<GetComicCreatorsResponse> getCreatorsByComicId(int comicId) {
        return Single.just(comicId)
                .flatMap(new Function<Integer, SingleSource<GetComicCreatorsResponse>>() {
                    @Override
                    public SingleSource<GetComicCreatorsResponse> apply(Integer integer) throws Exception {
                        long timeMillis = System.currentTimeMillis();
                        return apiService.getCreatorsByComicById(
                                integer,
                                publicKey,
                                Security.generateHash(privateKey, publicKey, timeMillis),
                                timeMillis
                        );
                    }
                });
    }
}
