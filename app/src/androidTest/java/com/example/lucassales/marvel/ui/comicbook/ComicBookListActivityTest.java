package com.example.lucassales.marvel.ui.comicbook;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.lucassales.marvel.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by lucassales on 30/11/2017.
 */

@RunWith(AndroidJUnit4.class)
public class ComicBookListActivityTest {

    @Rule
    public ActivityTestRule<ComicBookListActivity> mActivityRule =
            new ActivityTestRule<>(ComicBookListActivity.class);

    @Test
    public void checkViews() {

        onView(withId(R.id.recyclerView))
                .check(matches(isDisplayed()));

        onView(withId(R.id.button))
                .check(matches(isDisplayed()));

        onView(withId(R.id.button))
                .check(matches(isClickable()));

    }

}