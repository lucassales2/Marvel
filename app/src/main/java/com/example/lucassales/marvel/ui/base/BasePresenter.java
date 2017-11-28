package com.example.lucassales.marvel.ui.base;

import com.example.lucassales.marvel.data.DataManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by lucassales on 28/11/2017.
 */

public class BasePresenter<V extends IView> implements IPresenter<V> {

    private final DataManager dataManager;
    private final CompositeDisposable compositeDisposable;
    private V view;

    @Inject
    public BasePresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        this.dataManager = dataManager;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        compositeDisposable.dispose();
        view = null;
    }

    protected V getView() {
        return view;
    }

    protected boolean isViewAttached() {
        return view != null;
    }

    protected DataManager getDataManager() {
        return dataManager;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}
