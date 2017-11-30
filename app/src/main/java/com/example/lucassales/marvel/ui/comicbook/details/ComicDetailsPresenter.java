package com.example.lucassales.marvel.ui.comicbook.details;

import android.text.Html;

import com.example.lucassales.marvel.data.DataManager;
import com.example.lucassales.marvel.data.db.entity.Comic;
import com.example.lucassales.marvel.data.mapper.EntityMapper;
import com.example.lucassales.marvel.data.network.response.GetComicByIdResponse;
import com.example.lucassales.marvel.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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
                .map(new Function<GetComicByIdResponse, Comic>() {
                    @Override
                    public Comic apply(GetComicByIdResponse getComicByIdResponse) throws Exception {
                        return EntityMapper.mapToEntity(getComicByIdResponse.getData().getResults().get(0));
                    }
                })
                .subscribe(new Consumer<Comic>() {
                    @Override
                    public void accept(Comic comic) throws Exception {
                        getDataManager().insertComicBookDB(comic);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));

        getCompositeDisposable().add(getDataManager()
                .getComicByIdDB((long) comicId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Comic>() {
                    @Override
                    public void accept(Comic comic) throws Exception {
                        if (isViewAttached()) {
                            getIView().onImageLoaded(comic.getImage());
                            getIView().onTitleLoaded(comic.getTitle());
                            getIView().onDescriptionLoaded(comic.getDescription() != null ?
                                    Html.fromHtml(comic.getDescription()) :
                                    "No description available");
                            getIView().onPageCountLoaded(String.valueOf(comic.getPageCount()));
                            getIView().onPriceLoaded(String.valueOf(comic.getPrice()));
                            getIView().onCreatorsLoaded(comic.getCreators());

                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));

    }
}
