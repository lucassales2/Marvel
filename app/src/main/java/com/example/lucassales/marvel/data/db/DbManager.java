package com.example.lucassales.marvel.data.db;

import com.example.lucassales.marvel.data.network.dto.Comic;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by lucassales on 28/11/2017.
 */

public interface DbManager {
    Flowable<List<Comic>> getAllComicBooks();

    long insetComicBook(Comic comic);

    void bulkInsertComicBook(List<Comic> comics);
}
