package com.example.lucassales.marvel.data.db;

import com.example.lucassales.marvel.data.db.entity.Comic;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Created by lucassales on 28/11/2017.
 */

public class DbManagerImpl implements DbManager {

    private MarvelRoomDatabase database;

    @Inject
    public DbManagerImpl(MarvelRoomDatabase database) {
        this.database = database;
    }

    @Override
    public Flowable<List<Comic>> getAllComicBooksDB() {
        return database.getComicDao().getAllComics();
    }

    @Override
    public long insertComicBookDB(Comic comic) {
        return database.getComicDao().insertComicBook(comic);
    }

    @Override
    public void bulkInsertComicBookDB(List<Comic> comics) {
        database.getComicDao().insertAll(comics);
    }

    @Override
    public Flowable<Comic> getComicByIdDB(long id) {
        return database.getComicDao().getComicById(id);
    }

    @Override
    public Maybe<List<Float>> getPricesDB() {
        return database.getComicDao().getPrices();
    }
}
