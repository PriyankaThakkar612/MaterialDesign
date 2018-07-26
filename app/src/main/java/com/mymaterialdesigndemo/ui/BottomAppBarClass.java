package com.mymaterialdesigndemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.button.MaterialButton;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.mymaterialdesigndemo.R;

public class BottomAppBarClass extends AppCompatActivity implements View.OnClickListener {

    BottomAppBar bottomAppBar;
    MaterialButton center, end;
    ToggleButton toggleButton;
    FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_view);
        setTitle(R.string.title_bottom_app_bar);

        init();

        bottomAppBar.replaceMenu(R.menu.menu_bottom_app_bar);
//        setUpBottomDrawer();
        toggleButton.setChecked(fab.getVisibility() == View.VISIBLE);
        toggleButton.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if (isChecked) {
                        fab.show();
                    } else {
                        fab.hide();
                    }
                });

    }

    private void init() {
        bottomAppBar = findViewById(R.id.bottom_appbar);
        fab = findViewById(R.id.fab);
        center = findViewById(R.id.center);
        end = findViewById(R.id.end);
        toggleButton = findViewById(R.id.attach_toggle);
        coordinatorLayout = findViewById(R.id.coordinator_layout);
        center.setOnClickListener(this);
        end.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.center) {
            bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        }
        if (id == R.id.end) {
            bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
        }

    }

    protected void setUpBottomDrawer() {
        View bottomDrawer = coordinatorLayout.findViewById(R.id.bottom_drawer);
         BottomSheetBehavior<View> bottomDrawerBehavior;
        bottomDrawerBehavior = BottomSheetBehavior.from(bottomDrawer);
        bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        bottomAppBar.setNavigationOnClickListener(
                v -> bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED));
        bottomAppBar.setNavigationIcon(R.drawable.ic_notifications_black_24dp);
        bottomAppBar.replaceMenu(R.menu.navigation);
    }
}
