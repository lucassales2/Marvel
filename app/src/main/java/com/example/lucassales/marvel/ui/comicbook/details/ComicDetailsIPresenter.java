package com.example.lucassales.marvel.ui.comicbook.details;

import com.example.lucassales.marvel.ui.base.IPresenter;

/**
 * Created by lucassales on 28/11/2017.
 */

public interface ComicDetailsIPresenter<V extends ComicDetailsIView> extends IPresenter<V> {

    void start(int comicId);
}
