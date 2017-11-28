package com.example.lucassales.marvel.ui.base;

/**
 * Created by lucassales on 28/11/2017.
 */

public interface IPresenter<V extends IView> {
    void onAttach(V view);

    void onDetach();
}
