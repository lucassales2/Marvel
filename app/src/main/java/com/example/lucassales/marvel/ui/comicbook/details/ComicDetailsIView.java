package com.example.lucassales.marvel.ui.comicbook.details;

import com.example.lucassales.marvel.data.network.dto.Comic;
import com.example.lucassales.marvel.ui.base.IView;

/**
 * Created by lucassales on 28/11/2017.
 */

public interface ComicDetailsIView extends IView {
    void onComicBookLoaded(Comic comic);
}
