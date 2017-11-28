package com.example.lucassales.marvel.ui.comicbook.details;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lucassales on 28/11/2017.
 */

@Module
public class ComicDetailsModule {

    @Provides
    ComicDetailsIPresenter<ComicDetailsIView> provideComicDetailsIPresenter(
            ComicDetailsPresenter<ComicDetailsIView> presenter) {
        return presenter;
    }

}
