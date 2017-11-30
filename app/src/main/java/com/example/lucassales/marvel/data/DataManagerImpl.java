package com.example.lucassales.marvel.data;

import android.content.Context;

import com.example.lucassales.marvel.data.db.DbManager;
import com.example.lucassales.marvel.data.db.entity.Comic;
import com.example.lucassales.marvel.data.network.ApiManager;
import com.example.lucassales.marvel.data.network.response.GetComicByIdResponse;
import com.example.lucassales.marvel.data.network.response.GetComicCreatorsResponse;
import com.example.lucassales.marvel.data.network.response.GetComicsResponse;
import com.example.lucassales.marvel.inject.ApplicationContext;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by lucassales on 28/11/2017.
 */

@Singleton
public class DataManagerImpl implements DataManager {

    private final Context context;
    private final ApiManager apiManager;
    private DbManager dbManager;

    @Inject
    public DataManagerImpl(@ApplicationContext Context context, ApiManager apiManager, DbManager dbManager) {
        this.context = context;
        this.apiManager = apiManager;
        this.dbManager = dbManager;
    }

    @Override
    public Flowable<List<Comic>> getAllComicBooksDB() {
        return dbManager.getAllComicBooksDB();
    }

    @Override
    public long insertComicBookDB(Comic comic) {
        return dbManager.insertComicBookDB(comic);
    }

    @Override
    public void bulkInsertComicBookDB(List<Comic> comics) {
        dbManager.bulkInsertComicBookDB(comics);
    }

    @Override
    public Flowable<Comic> getComicByIdDB(long id) {
        return dbManager.getComicByIdDB(id);
    }

    @Override
    public Maybe<List<Float>> getPricesDB() {
        return dbManager.getPricesDB();
    }

    @Override
    public Single<GetComicsResponse> getComicBooks() {
        return apiManager.getComicBooks();
    }

    @Override
    public Single<GetComicByIdResponse> getComicById(int comicId) {
        return apiManager.getComicById(comicId);
    }

    @Override
    public Single<GetComicCreatorsResponse> getCreatorsByComicId(int comicId) {
        return apiManager.getCreatorsByComicId(comicId);
    }
}
