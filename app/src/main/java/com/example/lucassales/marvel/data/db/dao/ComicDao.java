package com.example.lucassales.marvel.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.lucassales.marvel.data.network.dto.Comic;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by lucassales on 29/11/2017.
 */

@Dao
public interface ComicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Comic> comicList);

    @Query("")
    Flowable<List<Comic>> getAllComics();
}
