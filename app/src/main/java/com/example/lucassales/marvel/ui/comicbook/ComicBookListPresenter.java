package com.example.lucassales.marvel.ui.comicbook;

import com.example.lucassales.marvel.data.DataManager;
import com.example.lucassales.marvel.data.db.entity.Comic;
import com.example.lucassales.marvel.data.mapper.EntityMapper;
import com.example.lucassales.marvel.data.network.dto.ComicDTO;
import com.example.lucassales.marvel.data.network.response.GetComicsResponse;
import com.example.lucassales.marvel.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
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
        getCompositeDisposable().add(getDataManager().getComicBooks()
                .subscribeOn(Schedulers.io())
                .map(new Function<GetComicsResponse, List<Comic>>() {
                    @Override
                    public List<Comic> apply(GetComicsResponse getComicsResponse) throws Exception {
                        List<Comic> comics = new ArrayList<>();
                        for (ComicDTO comicDTO : getComicsResponse.getData().getResults()) {
                            comics.add(EntityMapper.mapToEntity(comicDTO));
                        }
                        return comics;
                    }
                })
                .subscribe(new Consumer<List<Comic>>() {
                    @Override
                    public void accept(List<Comic> comicList) throws Exception {
                        getDataManager().bulkInsertComicBookDB(comicList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));

        getCompositeDisposable().add(getDataManager().getAllComicBooksDB()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Comic>>() {
                    @Override
                    public void accept(List<Comic> comics) throws Exception {
                        if (isViewAttached()) {
                            getIView().onComicBooksLoaded(comics);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }

    @Override
    public void calculateWithBudget(final float budget) {
        getCompositeDisposable().add(getDataManager().getPricesDB()
                .map(new Function<List<Float>, Integer>() {
                    @Override
                    public Integer apply(List<Float> prices) throws Exception {
                        float total = 0;
                        for (int i = 0; i < prices.size(); i++) {
                            float price = prices.get(i);
                            total += price;
                            if (total > budget) {
                                return i;
                            }
                        }
                        return prices.size();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        if (isViewAttached()) {
                            getIView().onBudgetCalculated(integer);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }


}
