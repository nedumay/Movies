package com.example.movies.ui.DetailActivity.adapter.trailer;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.movies.domain.Trailer;

public class TrailerItemDiffCallback extends DiffUtil.ItemCallback<Trailer> {
    @Override
    public boolean areItemsTheSame(@NonNull Trailer oldItem, @NonNull Trailer newItem) {
        return oldItem.getUrl().equals(newItem.getUrl());
    }

    @SuppressLint("DiffUtilEquals")
    @Override
    public boolean areContentsTheSame(@NonNull Trailer oldItem, @NonNull Trailer newItem) {
        return oldItem.equals(newItem);
    }
}
