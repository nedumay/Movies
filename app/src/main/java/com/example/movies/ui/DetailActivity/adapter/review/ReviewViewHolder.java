package com.example.movies.ui.DetailActivity.adapter.review;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;

public class ReviewViewHolder extends RecyclerView.ViewHolder{

    protected final TextView textViewAuthor;
    protected final TextView textViewReview;
    protected final ConstraintLayout backgroundReview;

    public ReviewViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
        textViewReview = itemView.findViewById(R.id.textViewReview);
        backgroundReview = itemView.findViewById(R.id.backgroundReview);
    }

}
