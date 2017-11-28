package com.example.lucassales.marvel.inject;

import com.example.lucassales.marvel.ui.comicbook.ComicBookListActivity;
import com.example.lucassales.marvel.ui.comicbook.ComicBookListModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by lucassales on 28/11/2017.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = ComicBookListModule.class)
    abstract ComicBookListActivity bindComicBookListActivity();
}
