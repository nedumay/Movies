package com.example.movies.ui.Main.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.bumptech.glide.Glide;
import com.example.movies.domain.Movie;
import com.example.movies.R;

public class MoviesAdapter extends ListAdapter<Movie, MovieViewHolder> {

    public MoviesAdapter(@NonNull DiffUtil.ItemCallback<Movie> diffCallback) {
        super(diffCallback);
    }

    private OnReachEndListener onReachEndListener;
    public void setOnReachEndListener(OnReachEndListener onReachEndListener) {
        this.onReachEndListener = onReachEndListener;
    }

    private OnClickListener onClickListener;
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.movie_item,
                parent,
                false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = getItem(position);
        Glide.with(holder.itemView)
                .load(movie.getPoster().getUrl())
                .into(holder.imageViewPoster);
        double rating = movie.getRating().getKp();
        int bacgroundId;
        if (rating > 7){
            bacgroundId = R.drawable.circle_green;
        } else if(rating > 5){
            bacgroundId = R.drawable.circle_orange;
        } else {
            bacgroundId = R.drawable.circle_red;
        }
        Drawable background = ContextCompat.getDrawable(holder.itemView.getContext(),bacgroundId);
        holder.textViewPoster.setBackground(background);
        holder.textViewPoster.setText(String.format("%.1f",rating));

        if (position >= getCurrentList().size() - 10 && onReachEndListener != null){
            onReachEndListener.onReachEnd();
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onClickListener != null){
                    onClickListener.onClick(movie);
                }
            }
        });
    }

    public interface OnReachEndListener{
        void onReachEnd(); //Конец списка
    }

    public interface OnClickListener{
        void onClick(Movie movie);
    }


}
