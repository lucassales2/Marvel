package com.example.lucassales.marvel.ui.comicbook;

import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.example.lucassales.marvel.R;
import com.example.lucassales.marvel.data.db.entity.Comic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucassales on 28/11/2017.
 */

public class ComicBookListAdapter extends RecyclerView.Adapter<ComicBookListAdapter.ViewHolder> {

    private List<Comic> comics = new ArrayList<Comic>();
    private WeakReference<OnComicClickListener> listener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_comicbook, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Comic comic = comics.get(position);
        Glide.with(holder.imageView)
                .asBitmap()
                .load(comic.getImage())
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        Palette palette = new Palette.Builder(resource).generate();
                        int color = palette.getLightMutedColor(
                                ContextCompat.getColor(holder.itemView.getContext(), R.color.colorPrimary));
                        holder.imageView.setImageBitmap(resource);
                        holder.itemView.setBackgroundColor(color);
                    }
                });
        holder.textView.setText(comic.getTitle());
    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    public void update(List<Comic> results) {
        comics.clear();
        comics.addAll(results);
        notifyDataSetChanged();
    }

    public void setListener(OnComicClickListener listener) {
        this.listener = new WeakReference<>(listener);
    }

    public interface OnComicClickListener {
        void onComicClick(Comic comic, AppCompatTextView textView, AppCompatImageView imageView, View itemView);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final AppCompatTextView textView;
        final AppCompatImageView imageView;

        public ViewHolder(final View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null && listener.get() != null) {
                        listener.get().onComicClick(comics.get(getLayoutPosition()), textView, imageView, itemView);
                    }
                }
            });
        }
    }
}
