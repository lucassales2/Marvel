package com.example.lucassales.marvel.ui.comicbook.details;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;

import com.bumptech.glide.Glide;
import com.example.lucassales.marvel.R;
import com.example.lucassales.marvel.data.network.dto.Comic;
import com.example.lucassales.marvel.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicDetailsActivity extends BaseActivity implements ComicDetailsIView {

    private static final String COMIC_ID = "comicId";

    @Inject
    ComicDetailsIPresenter<ComicDetailsIView> presenter;
    @BindView(R.id.imageViewComic)
    AppCompatImageView imageViewComic;
    @BindView(R.id.textViewTitle)
    AppCompatTextView textViewTitle;
    @BindView(R.id.textViewDescription)
    AppCompatTextView textViewDescription;
    @BindView(R.id.textViewPageCount)
    AppCompatTextView textViewPageCount;
    @BindView(R.id.textViewPrice)
    AppCompatTextView textViewPrice;

    public static Intent getStartIntent(Context context, int comicId) {
        return new Intent(context, ComicDetailsActivity.class)
                .putExtra(COMIC_ID, comicId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_details);
        setUnbinder(ButterKnife.bind(this));
        presenter.onAttach(this);
        int comicId = getIntent().getIntExtra(COMIC_ID, 0);
        presenter.start(comicId);
    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void onComicBookLoaded(Comic comic) {
        Glide.with(this)
                .load(comic.getThumbnail().getPath() + "." + comic.getThumbnail().getExtension())
                .into(imageViewComic);
        textViewTitle.setText(comic.getTitle());
        if (comic.getDescription() != null)
            textViewDescription.setText(Html.fromHtml(comic.getDescription()));
        textViewPageCount.setText(comic.getPageCount());
        textViewPrice.setText(comic.getPrices().get(0).getPrice());
    }
}
