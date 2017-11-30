package com.example.lucassales.marvel.data.db.contract;

import android.provider.BaseColumns;

/**
 * Created by lucassales on 30/11/2017.
 */

public class DbContract {

    public static class ComicContract {
        public static final String TABLE_NAME = "comic";

        public static class Columns implements BaseColumns {
            public static final String TITLE = "title";
            public static final String DESCRIPTION = "description";
            public static final String PRICE = "price";
            public static final String PAGE_COUNT = "page_count";
            public static final String IMAGE = "image";
            public static final String CREATORS = "creators";
        }
    }
}
