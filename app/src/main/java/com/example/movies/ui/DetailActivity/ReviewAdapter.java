package com.example.movies.ui.DetailActivity;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.domain.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.RieviewViewHolder> {

    private static final String TYPE_POSITIVE = "Позитивный";
    private static final String TYPE_NEUTRAL = "Нейтральный";

    private List<Review> reviews = new ArrayList<>();

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RieviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.review_item,
                parent,
                false);
        return new RieviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RieviewViewHolder holder, int position) {
        Review review = reviews.get(position);
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

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    static class RieviewViewHolder extends RecyclerView.ViewHolder{

        private final TextView textViewAuthor;
        private final TextView textViewReview;
        private final ConstraintLayout backgroundReview;

        public RieviewViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
            textViewReview = itemView.findViewById(R.id.textViewReview);
            backgroundReview = itemView.findViewById(R.id.backgroundReview);
        }

    }
}
