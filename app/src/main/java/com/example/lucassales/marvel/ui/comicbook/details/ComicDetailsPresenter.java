package com.example.lucassales.marvel.ui.comicbook.details;

import com.example.lucassales.marvel.data.DataManager;
import com.example.lucassales.marvel.data.network.dto.Comic;
import com.example.lucassales.marvel.data.network.response.GetComicByIdResponse;
import com.example.lucassales.marvel.ui.base.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lucassales on 28/11/2017.
 */

public class ComicDetailsPresenter<V extends ComicDetailsIView> extends BasePresenter<V> implements ComicDetailsIPresenter<V> {

    @Inject
    public ComicDetailsPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }


    @Override
    public void start(int comicId) {
        getCompositeDisposable().add(getDataManager().getComicById(comicId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GetComicByIdResponse>() {
                    @Override
                    public void accept(GetComicByIdResponse getComicByIdResponse) throws Exception {
                        if (isViewAttached()) {
                            List<Comic> results = getComicByIdResponse.getData().getResults();
                            if (!results.isEmpty())
                                getView().onComicBookLoaded(results.get(0));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }
}
