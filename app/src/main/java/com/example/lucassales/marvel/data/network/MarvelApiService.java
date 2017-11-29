package com.example.lucassales.marvel.data.network;

import com.example.lucassales.marvel.data.network.response.GetComicByIdResponse;
import com.example.lucassales.marvel.data.network.response.GetComicCreatorsResponse;
import com.example.lucassales.marvel.data.network.response.GetComicsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by lucassales on 27/11/2017.
 */

public interface MarvelApiService {
    @GET("comics")
    Single<GetComicsResponse> getComics(
            @Query("apikey") String apikey,
            @Query("hash") String hash,
            @Query("ts") long timeStamp,
            @Query("limit") int limit
    );

    @GET("comics/{comicId}")
    Single<GetComicByIdResponse> getComicById(
            @Path("comicId") int comicId,
            @Query("apikey") String apikey,
            @Query("hash") String hash,
            @Query("ts") long timeStamp
    );

    @GET("comics/{comicId}/creators")
    Single<GetComicCreatorsResponse> getCreatorsByComicById(
            @Path("comicId") int comicId,
            @Query("apikey") String apikey,
            @Query("hash") String hash,
            @Query("ts") long timeStamp
    );
}
