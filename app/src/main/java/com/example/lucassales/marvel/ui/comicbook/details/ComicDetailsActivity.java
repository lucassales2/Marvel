package com.example.lucassales.marvel.ui.comicbook.details;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.lucassales.marvel.R;
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
    @BindView(R.id.rootView)
    View rootView;
    @BindView(R.id.textViewCreators)
    AppCompatTextView textViewCreators;


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
    public void onImageLoaded(String imageUrl) {
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        imageViewComic.setImageBitmap(resource);
                        Palette palette = new Palette.Builder(resource).generate();
                        int color = palette.getLightMutedColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                        rootView.setBackgroundColor(color);
                    }
                });
    }

    @Override
    public void onTitleLoaded(String title) {
        textViewTitle.setText(title);
    }

    @Override
    public void onDescriptionLoaded(CharSequence charSequence) {
        textViewDescription.setText(getString(R.string.description, charSequence));
    }

    @Override
    public void onPageCountLoaded(String pageCount) {
        textViewPageCount.setText(getString(R.string.page_count, pageCount));
    }

    @Override
    public void onPriceLoaded(String type, String price) {
        textViewPrice.setText(getString(R.string.price, type, price));
    }

    @Override
    public void onCreatorsLoaded(String creators) {
        textViewCreators.setText(getString(R.string.creators, creators));
    }
}
