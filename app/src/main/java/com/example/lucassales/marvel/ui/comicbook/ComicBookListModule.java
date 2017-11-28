package com.example.lucassales.marvel.ui.comicbook;

import dagger.Module;
import dagger.Provides;

/**
 * Created by lucassales on 28/11/2017.
 */

@Module
public class ComicBookListModule {

    @Provides
    ComicBookListIPresenter<ComicBookListIView> provideComicBookListIPresenter(
            ComicBookListPresenter<ComicBookListIView> presenter) {
        return presenter;
    }
}
