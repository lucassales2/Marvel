package com.example.lucassales.marvel.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.lucassales.marvel.data.db.dao.ComicDao;
import com.example.lucassales.marvel.data.db.entity.Comic;

/**
 * Created by lucassales on 30/11/2017.
 */

@Database(entities = {Comic.class}, version = 1, exportSchema = false)
public abstract class MarvelRoomDatabase extends RoomDatabase {
    abstract ComicDao getComicDao();
}
