package com.example.lucassales.marvel.data.db;

import com.example.lucassales.marvel.data.db.entity.Comic;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Created by lucassales on 28/11/2017.
 */

public interface DbManager {
    Flowable<List<Comic>> getAllComicBooksDB();

    long insertComicBookDB(Comic comic);

    void bulkInsertComicBookDB(List<Comic> comics);

    Flowable<Comic> getComicByIdDB(long id);

    Maybe<List<Float>> getPricesDB();
}
