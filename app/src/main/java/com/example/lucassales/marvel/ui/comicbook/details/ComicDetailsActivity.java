package com.example.lucassales.marvel.ui.comicbook.details;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
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
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;


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
                .asBitmap()
                .load(comic.getThumbnail().getPath() + "." + comic.getThumbnail().getExtension())
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        imageViewComic.setImageBitmap(resource);
                        Palette palette = new Palette.Builder(resource).generate();
                        int defaultC = ContextCompat.getColor(ComicDetailsActivity.this, R.color.colorPrimary);
                        int color = palette.getVibrantColor(defaultC); //always ok
                        linearLayout.setBackgroundColor(color);
                    }
                });
        textViewTitle.setText(comic.getTitle());
        textViewDescription.setText(comic.getDescription() != null ? Html.fromHtml(comic.getDescription()) : "No description available");
        textViewPageCount.setText(comic.getPageCount());
        textViewPrice.setText(comic.getPrices().get(0).getPrice());
    }
}
