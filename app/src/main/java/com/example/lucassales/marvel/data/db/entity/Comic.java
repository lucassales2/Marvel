package com.example.lucassales.marvel.data.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static com.example.lucassales.marvel.data.db.contract.DbContract.ComicContract.TABLE_NAME;

/**
 * Created by lucassales on 30/11/2017.
 */

@Entity(tableName = TABLE_NAME)
public class Comic {

    @PrimaryKey
    private long id;
    @NonNull
    private String title;
    private String description;
    @NonNull
    private String image;
    private float price;
    private int pageCount;
    @NonNull
    private String creators;

    public Comic(long id, @NonNull String title, String description, @NonNull String image, float price, int pageCount, @NonNull String creators) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
        this.pageCount = pageCount;
        this.creators = creators;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    public String getImage() {
        return image;
    }

    public void setImage(@NonNull String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    @NonNull
    public String getCreators() {
        return creators;
    }

    public void setCreators(@NonNull String creators) {
        this.creators = creators;
    }
}
