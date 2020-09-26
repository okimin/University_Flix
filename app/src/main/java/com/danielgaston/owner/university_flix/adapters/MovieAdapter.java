package com.danielgaston.owner.university_flix.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.danielgaston.owner.university_flix.R;
import com.danielgaston.owner.university_flix.models.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.Viewholder>{

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies){
        this.context = context;
        this.movies = movies;

    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View movieView= LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        return new Viewholder(movieView);
    }


    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Movie movie= movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvOverview;
        ImageView ivPoster;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview =itemView.findViewById(R.id.tvOverview);
            ivPoster =itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            String imageUrl;
            if(context.getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
                imageUrl= movie.getBackdropPath();
            }
            else
                imageUrl= movie.getPosterPath();
            Glide.with(context).load(imageUrl).into(ivPoster);
        }
    }
}
