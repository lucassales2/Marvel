package com.example.lucassales.marvel.ui.base;

import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by lucassales on 28/11/2017.
 */

public abstract class BaseActivity extends DaggerAppCompatActivity implements IView {

    private Unbinder unbinder;

    protected void setUnbinder(Unbinder unbinder) {
        this.unbinder = unbinder;
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroy();
    }

}
