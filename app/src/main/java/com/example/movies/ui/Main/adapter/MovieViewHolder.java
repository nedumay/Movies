package com.example.movies.ui.Main.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;

 public class MovieViewHolder extends RecyclerView.ViewHolder {

    protected final ImageView imageViewPoster;
    protected final TextView textViewPoster;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        imageViewPoster = itemView.findViewById(R.id.imgeViewPoster);
        textViewPoster = itemView.findViewById(R.id.textViewPoster);
    }
}
