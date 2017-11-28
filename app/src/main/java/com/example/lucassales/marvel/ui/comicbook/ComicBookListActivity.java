package com.example.lucassales.marvel.ui.comicbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lucassales.marvel.R;
import com.example.lucassales.marvel.ui.base.BaseActivity;

import javax.inject.Inject;

public class ComicBookListActivity extends BaseActivity implements ComicBookListIView {

    @Inject
    ComicBookListIPresenter<ComicBookListIView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_book_list);
        presenter.onAttach(this);

    }
}
