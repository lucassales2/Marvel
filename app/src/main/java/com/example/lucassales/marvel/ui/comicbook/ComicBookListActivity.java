package com.example.lucassales.marvel.ui.comicbook;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lucassales.marvel.R;
import com.example.lucassales.marvel.data.network.dto.Comic;
import com.example.lucassales.marvel.ui.base.BaseActivity;
import com.example.lucassales.marvel.ui.comicbook.details.ComicDetailsActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicBookListActivity extends BaseActivity implements ComicBookListIView, ComicBookListAdapter.OnComicClickListener {

    @Inject
    ComicBookListIPresenter<ComicBookListIView> presenter;
    @Inject
    ComicBookListAdapter adapter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_book_list);
        setUnbinder(ButterKnife.bind(this));
        presenter.onAttach(this);
        presenter.start();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter.setListener(this);

    }

    @Override
    public void onComicBooksLoaded(List<Comic> results) {
        adapter.update(results);
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onComicClick(Comic comic) {
        startActivity(ComicDetailsActivity.getStartIntent(this, Integer.valueOf(comic.getId())));
    }
}
