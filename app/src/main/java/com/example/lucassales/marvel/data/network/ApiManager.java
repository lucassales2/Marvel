package com.example.lucassales.marvel.data.network;

import com.example.lucassales.marvel.data.network.response.GetComicByIdResponse;
import com.example.lucassales.marvel.data.network.response.GetComicsResponse;

import io.reactivex.Single;

/**
 * Created by lucassales on 28/11/2017.
 */

public interface ApiManager {

    Single<GetComicsResponse> getComicBooks();

    Single<GetComicByIdResponse> getComicById(int comicId);
}
