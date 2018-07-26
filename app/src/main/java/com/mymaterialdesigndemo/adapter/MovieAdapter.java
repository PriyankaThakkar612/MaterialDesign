package com.mymaterialdesigndemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mymaterialdesigndemo.R;
import com.mymaterialdesigndemo.bean.MovieBean;

import java.util.List;



public class MovieAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<MovieBean> movieList;


    public MovieAdapter(Context context, List<MovieBean> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_movie_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        MovieBean bean = movieList.get(position);

        holder.name.setText(bean.getMovieTitle());
        holder.price.setText(bean.getPrice());

        Glide.with(context)
                .load(bean.getImage())
                .into(holder.image);
    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView name, price;
    public ImageView image;

    public MyViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.tv_movie_title);
        price = itemView.findViewById(R.id.tv_movie_price);
        image = itemView.findViewById(R.id.iv_movie);
    }
}