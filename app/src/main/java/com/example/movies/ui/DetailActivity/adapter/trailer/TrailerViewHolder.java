package com.example.movies.ui.DetailActivity.adapter.trailer;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;

public class TrailerViewHolder extends RecyclerView.ViewHolder {

    protected final TextView textViewTrailer;

    public TrailerViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewTrailer = itemView.findViewById(R.id.textViewTitleTrailer);
    }
}
