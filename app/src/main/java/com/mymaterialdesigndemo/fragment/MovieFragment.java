package com.mymaterialdesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mymaterialdesigndemo.MyApplication;
import com.mymaterialdesigndemo.R;
import com.mymaterialdesigndemo.adapter.MovieAdapter;
import com.mymaterialdesigndemo.bean.MovieBean;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {

    private static final String TAG = "tag";
    private List<MovieBean> list;
    private MovieAdapter adapter;
    private static final String URL = "https://api.androidhive.info/json/movies_2017.json";

    public MovieFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_movie, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new MovieAdapter(getActivity(), list);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);

        fetchMovieList();

        return view;

    }

    public void fetchMovieList() {
        JsonArrayRequest request = new JsonArrayRequest(URL, response -> {

            if (response == null) {
                Toast.makeText(getActivity(), "Couldn't fetch the store items! Pleas try again.", Toast.LENGTH_LONG).show();
                return;
            }

            List<MovieBean> items = new Gson().
                    fromJson(response.toString(), new TypeToken<List<MovieBean>>() {}.getType());

            list.clear();
            list.addAll(items);

            // refreshing recycler view
            adapter.notifyDataSetChanged();

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error: " + error.getMessage());
                Toast.makeText(getActivity(), "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        MyApplication.getInstance().addToRequestQueue(request);
    }

}
