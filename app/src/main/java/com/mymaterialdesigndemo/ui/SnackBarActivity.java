package com.mymaterialdesigndemo.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mymaterialdesigndemo.R;

public class SnackBarActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        setTitle(R.string.title_snack_bar);

        init();

    }

    private void init() {
        Button btnSimpleSnackbar = findViewById(R.id.btn_simple_snackbar);
        Button btnCustomSnackbar = findViewById(R.id.btn_custom_snackbar);
        Button btnActionSnackbar = findViewById(R.id.btn_action_snackbar);
        FloatingActionButton fab = findViewById(R.id.fab_snackbar);


        btnSimpleSnackbar.setOnClickListener(this);
        btnCustomSnackbar.setOnClickListener(this);
        btnActionSnackbar.setOnClickListener(this);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_simple_snackbar) {
            Snackbar.make(view, R.string.simple_snackbar, Snackbar.LENGTH_SHORT).show();

        } else if (id == R.id.btn_custom_snackbar) {

            Snackbar snackbar = Snackbar.make(view, R.string.no_internet_connection, Snackbar.LENGTH_LONG)
                    .setAction(R.string.retry, view12 -> {
                    });

            // Change action message text color
            snackbar.setActionTextColor(Color.GREEN);

            // Change action button text color
            View view1 = snackbar.getView();
            TextView textView = view1.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.RED);

            snackbar.show();

        } else if (id == R.id.btn_action_snackbar) {
            Snackbar snackbar = Snackbar.make(view, R.string.data_deleted, Snackbar.LENGTH_LONG)
                    .setAction(R.string.undo, view13 -> {
                        Snackbar action_restore = Snackbar.make(view13, R.string.data_restored, Snackbar.LENGTH_LONG);
                        action_restore.show();
                    });
            snackbar.show();

        } else if (id == R.id.fab_snackbar) {
            Toast.makeText(this, R.string.fab_click, Toast.LENGTH_SHORT).show();
        }

    }
}
