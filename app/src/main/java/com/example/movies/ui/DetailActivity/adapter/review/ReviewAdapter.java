package com.example.movies.ui.DetailActivity.adapter.review;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.movies.R;
import com.example.movies.domain.Review;

public class ReviewAdapter extends ListAdapter<Review, ReviewViewHolder> {

    private static final String TYPE_POSITIVE = "Позитивный";
    private static final String TYPE_NEUTRAL = "Нейтральный";

    public ReviewAdapter(@NonNull DiffUtil.ItemCallback<Review> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false);
        return new ReviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Review review = getItem(position);
        holder.textViewAuthor.setText(review.getAuthor());
        holder.textViewReview.setText(review.getReview());
        String type = review.getType();
        int bacgroundId = R.color.light_red;
        switch (type){
            case TYPE_POSITIVE:
                bacgroundId = R.color.light_green;
                break;
            case TYPE_NEUTRAL:
                bacgroundId = R.color.light_orange;
                break;
        }
        int color = ContextCompat.getColor(holder.itemView.getContext(), bacgroundId);
        holder.backgroundReview.setBackgroundColor(color);
    }

}
