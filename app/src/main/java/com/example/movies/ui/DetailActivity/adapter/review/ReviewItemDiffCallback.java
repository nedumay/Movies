package com.example.movies.ui.DetailActivity.adapter.review;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.movies.domain.Review;

public class ReviewItemDiffCallback extends DiffUtil.ItemCallback<Review> {
    @Override
    public boolean areItemsTheSame(@NonNull Review oldItem, @NonNull Review newItem) {
        return oldItem.getAuthor().equals(newItem.getAuthor());
    }

    @SuppressLint("DiffUtilEquals")
    @Override
    public boolean areContentsTheSame(@NonNull Review oldItem, @NonNull Review newItem) {
        return oldItem.equals(newItem);
    }
}
