package com.example.lucassales.marvel.ui.comicbook;

import com.example.lucassales.marvel.ui.base.IPresenter;

/**
 * Created by lucassales on 28/11/2017.
 */

public interface ComicBookListIPresenter <V extends ComicBookListIView> extends IPresenter<V> {
    void start();

    void calculateWithBudget(float budget);
}
