package com.example.lucassales.marvel.ui.comicbook.details;

import com.example.lucassales.marvel.ui.base.IView;

/**
 * Created by lucassales on 28/11/2017.
 */

public interface ComicDetailsIView extends IView {

    void onImageLoaded(String imageUrl);

    void onTitleLoaded(String title);

    void onDescriptionLoaded(CharSequence charSequence);

    void onPageCountLoaded(String pageCount);

    void onPriceLoaded(String type, String price);

    void onCreatorsLoaded(String creators);
}
