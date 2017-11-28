package com.example.lucassales.marvel.data.db;

import com.example.lucassales.marvel.data.network.dto.Comic;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by lucassales on 28/11/2017.
 */

public class DbManagerImpl implements DbManager {

    @Inject
    public DbManagerImpl(){

    }

    @Override
    public Flowable<List<Comic>> getAllComicBooks() {
        return null;
    }

    @Override
    public long insetComicBook(Comic comic) {
        return 0;
    }

    @Override
    public void bulkInsertComicBook(List<Comic> comics) {

    }
}
