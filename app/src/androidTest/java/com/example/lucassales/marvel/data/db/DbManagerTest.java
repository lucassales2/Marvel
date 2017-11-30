package com.example.lucassales.marvel.data.db;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;

import com.example.lucassales.marvel.data.db.entity.Comic;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyString;

/**
 * Created by lucassales on 30/11/2017.
 */
public class DbManagerTest {

    DbManager dbManager;
    private MarvelRoomDatabase database;

    @Before
    public void start() {
        database = Room.inMemoryDatabaseBuilder(
                InstrumentationRegistry.getContext(),
                MarvelRoomDatabase.class)
                .build();
        dbManager = new DbManagerImpl(database);
    }

    @After
    public void closeDb() {
        database.close();
    }

    @Test
    public void insertAndGetComicBook() throws Exception {
        Comic mock = new Comic(anyLong(), anyString(), anyString(), anyString(), anyFloat(), anyInt(), anyString());

        long l = dbManager.insertComicBookDB(mock);
        Assert.assertEquals(l, mock.getId());
        Comic comic = dbManager.getComicByIdDB(l).blockingFirst();
        Assert.assertEquals(comic.getDescription(), mock.getDescription());
        Assert.assertEquals(comic.getImage(), mock.getImage());
        Assert.assertEquals(comic.getPageCount(), mock.getPageCount());
        Assert.assertEquals(comic.getPrice(), mock.getPrice(), mock.getPrice());
        Assert.assertEquals(comic.getTitle(), mock.getTitle());
    }


}