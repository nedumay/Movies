package com.example.movies.ui.DetailActivity.adapter.trailer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.R;
import com.example.movies.domain.Trailer;

import java.util.ArrayList;
import java.util.List;

public class TrailerAdapter extends ListAdapter<Trailer, TrailerViewHolder> {

    public TrailerAdapter(@NonNull DiffUtil.ItemCallback<Trailer> diffCallback) {
        super(diffCallback);
    }

    private OnClickListener onClickListener;
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public TrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trailer_item, parent,false);
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerViewHolder holder, int position) {
        Trailer trailer = getItem(position);
        holder.textViewTrailer.setText(trailer.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onClickListener != null){
                    onClickListener.onClick(trailer);
                }
            }
        });
    }
    public interface OnClickListener{
        void onClick(Trailer trailer);
    }
}
