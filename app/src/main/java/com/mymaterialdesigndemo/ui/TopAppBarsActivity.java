package com.mymaterialdesigndemo.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.mymaterialdesigndemo.R;

public class TopAppBarsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_app_bars);
        setTitle(R.string.top_app_bars);

        FloatingActionButton button = findViewById(R.id.fabTopAppBar);
        button.setOnClickListener(view -> Toast.makeText(TopAppBarsActivity.this, R.string.fab_click, Toast.LENGTH_SHORT).show());

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
