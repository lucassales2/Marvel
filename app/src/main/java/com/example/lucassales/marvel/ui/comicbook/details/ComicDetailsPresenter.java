package com.example.lucassales.marvel.ui.comicbook.details;

import android.text.Html;

import com.example.lucassales.marvel.data.DataManager;
import com.example.lucassales.marvel.data.network.dto.Comic;
import com.example.lucassales.marvel.data.network.dto.Image;
import com.example.lucassales.marvel.data.network.dto.Item;
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
                            Comic comic = results.get(0);
                            if (!results.isEmpty()) {
                                Image image;
                                if (comic.getImages().isEmpty()) {
                                    image = comic.getThumbnail();
                                } else {
                                    image = comic.getImages().get(0);
                                }
                                getIView().onImageLoaded(image.getPath() + "." + image.getExtension());

                                getIView().onTitleLoaded(comic.getTitle());
                                getIView().onDescriptionLoaded(comic.getDescription() != null ?
                                        Html.fromHtml(comic.getDescription()) :
                                        "No description available");

                                getIView().onPageCountLoaded(comic.getPageCount());

                                getIView().onPriceLoaded("$", comic.getPrices().get(0).getPrice());
                                StringBuilder builder = new StringBuilder();

                                List<Item> items = comic.getCreators().getItems();
                                if (items != null && !items.isEmpty()) {
                                    for (int i = 0; i < items.size(); i++) {
                                        Item item = items.get(i);
                                        if (i > 0) {
                                            builder.append(", ");
                                        }
                                        builder.append(item.getName());
                                    }
                                } else {
                                    builder.append("-");
                                }
                                getIView().onCreatorsLoaded(builder.toString());
                            }


                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));

    }
}
