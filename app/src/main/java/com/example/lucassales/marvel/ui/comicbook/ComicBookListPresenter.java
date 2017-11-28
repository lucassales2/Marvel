package com.example.lucassales.marvel.ui.comicbook;

import com.example.lucassales.marvel.data.DataManager;
import com.example.lucassales.marvel.data.network.response.GetComicsResponse;
import com.example.lucassales.marvel.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lucassales on 28/11/2017.
 */

public class ComicBookListPresenter<V extends ComicBookListIView> extends BasePresenter<V> implements ComicBookListIPresenter<V> {
    @Inject
    public ComicBookListPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void start() {
        getDataManager().getComicBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GetComicsResponse>() {
                    @Override
                    public void accept(GetComicsResponse getComicsResponse) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
