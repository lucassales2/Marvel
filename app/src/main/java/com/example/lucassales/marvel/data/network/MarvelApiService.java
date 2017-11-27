package com.example.lucassales.marvel.data.network;

import com.example.lucassales.marvel.data.network.dto.GetComicsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by lucassales on 27/11/2017.
 */

public interface MarvelApiService {
    @GET("/comics")
    Single<GetComicsResponse> getComics();


}
