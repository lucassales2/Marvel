package com.example.lucassales.marvel.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.lucassales.marvel.data.db.entity.Comic;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

/**
 * Created by lucassales on 29/11/2017.
 */

@Dao
public interface ComicDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Comic> comicList);

    @Query("select * from comic limit 100")
    Flowable<List<Comic>> getAllComics();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertComicBook(Comic comic);

    @Query("select * from comic where id = :id")
    Flowable<Comic> getComicById(long id);

    @Query("select price from comic order by price asc")
    Maybe<List<Float>> getPrices();
}
