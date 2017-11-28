package com.example.lucassales.marvel.ui.comicbook;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.lucassales.marvel.R;
import com.example.lucassales.marvel.data.network.dto.Comic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucassales on 28/11/2017.
 */

public class ComicBookListAdapter extends RecyclerView.Adapter<ComicBookListAdapter.ViewHolder> {

    private List<Comic> comics = new ArrayList<>();
    private WeakReference<OnComicClickListener> listener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_comicbook, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Comic comic = comics.get(position);
        Glide.with(holder.imageView)
                .load(String.format("%s.%s", comic.getThumbnail().getPath(), comic.getThumbnail().getExtension()))
                .into(holder.imageView);
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
        void onComicClick(Comic comic);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final AppCompatTextView textView;
        final AppCompatImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null && listener.get() != null) {
                        listener.get().onComicClick(comics.get(getLayoutPosition()));
                    }
                }
            });
        }
    }
}
