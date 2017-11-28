package com.example.lucassales.marvel.data.network;

import com.example.lucassales.marvel.data.network.response.GetComicsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lucassales on 27/11/2017.
 */

public interface MarvelApiService {
    @GET("comics")
    Single<GetComicsResponse> getComics(@Query("apikey") String apikey, @Query("hash") String hash, @Query("ts") long timeStamp);


}
