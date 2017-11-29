package com.example.lucassales.marvel.ui.comicbook;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;

import com.example.lucassales.marvel.R;
import com.example.lucassales.marvel.data.network.dto.Comic;
import com.example.lucassales.marvel.ui.base.BaseActivity;
import com.example.lucassales.marvel.ui.comicbook.details.ComicDetailsActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComicBookListActivity extends BaseActivity implements ComicBookListIView, ComicBookListAdapter.OnComicClickListener {

    @Inject
    ComicBookListIPresenter<ComicBookListIView> presenter;
    @Inject
    ComicBookListAdapter adapter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @OnClick(R.id.button)
    void onButtonClick(View view) {
        presenter.calculateWithBudget(10f);
    }

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
    public void onBudgetCalculated(int comicsToBeBought) {
        Toast.makeText(this, getString(R.string.comics_to_be_bought, comicsToBeBought), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onComicClick(Comic comic, AppCompatTextView textView, AppCompatImageView imageView) {
        Intent intent = ComicDetailsActivity.getStartIntent(this, Integer.valueOf(comic.getId()));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this, new Pair<View, String>(textView, "title"),
                    new Pair<View, String>(imageView, "image"));
            startActivity(intent, activityOptions.toBundle());
        } else {
            startActivity(intent);
        }

    }
}
