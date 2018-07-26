package com.mymaterialdesigndemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mymaterialdesigndemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton bottomAppBar, bottomNavigationBar, snackbar, modelBottomSheets, topAppBars, textField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.title_material_design);
        init();

    }

    private void init() {
        bottomAppBar = findViewById(R.id.btn_bottom_app_bar);
        bottomAppBar.setOnClickListener(this);

        bottomNavigationBar = findViewById(R.id.btn_bottom_navigation);
        bottomNavigationBar.setOnClickListener(this);

        snackbar = findViewById(R.id.btn_snackbar);
        snackbar.setOnClickListener(this);

        modelBottomSheets = findViewById(R.id.btn_model_bottom_sheets);
        modelBottomSheets.setOnClickListener(this);

        topAppBars = findViewById(R.id.btn_top_app_bars);
        topAppBars.setOnClickListener(this);


        textField = findViewById(R.id.btn_text_field);
        textField.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_bottom_app_bar) {
            Intent intent = new Intent(this, BottomAppBarClass.class);
            startActivity(intent);

        } else if (id == R.id.btn_bottom_navigation) {
            Intent intent = new Intent(this, BottomNavigationBar.class);
            startActivity(intent);

        } else if (id == R.id.btn_snackbar) {
            Intent intent = new Intent(this, SnackBarActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_model_bottom_sheets) {
            Intent intent = new Intent(this, ModelBottomSheetsActivity.class);
            startActivity(intent);
        } else if (id == R.id.btn_top_app_bars) {
            Intent intent = new Intent(this, TopAppBarsActivity.class);
            startActivity(intent);
        }else if (id == R.id.btn_text_field) {
            Intent intent = new Intent(this, TextFieldActivity.class);
            startActivity(intent);
        }
    }
}
