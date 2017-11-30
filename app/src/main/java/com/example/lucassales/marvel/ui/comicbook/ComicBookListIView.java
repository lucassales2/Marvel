package com.example.lucassales.marvel.ui.comicbook;

import com.example.lucassales.marvel.data.db.entity.Comic;
import com.example.lucassales.marvel.ui.base.IView;

import java.util.List;

/**
 * Created by lucassales on 28/11/2017.
 */

public interface ComicBookListIView extends IView {
    void onComicBooksLoaded(List<Comic> results);

    void onBudgetCalculated(int comicsToBeBought);
}
