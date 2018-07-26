package com.mymaterialdesigndemo.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.mymaterialdesigndemo.R;

public class ModelBottomSheetsActivity extends AppCompatActivity {

    Button btnBottomSheet, btnBottomSheetDialog;
    BottomSheetBehavior sheetBehavior;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_bottom_sheets);
        setTitle(R.string.title_model_bottom_sheets);

        btnBottomSheet = findViewById(R.id.btn_bottom_sheet);
        btnBottomSheetDialog = findViewById(R.id.btn_bottom_sheet_dialog);
        linearLayout = findViewById(R.id.bottom_sheet);

        btnBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                    btnBottomSheet.setText(R.string.close_sheet);
                } else {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    btnBottomSheet.setText(R.string.expand_sheet);
                }

            }
        });

        btnBottomSheetDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1 = getLayoutInflater().inflate(R.layout.model_bottom_sheet_dialog, null);

                BottomSheetDialog sheetDialog = new BottomSheetDialog(ModelBottomSheetsActivity.this);
                sheetDialog.setContentView(view1);
                sheetDialog.show();

            }
        });

        sheetBehavior = BottomSheetBehavior.from(linearLayout);

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED: {
                        btnBottomSheet.setText(R.string.close_sheet);
                    }

                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        btnBottomSheet.setText(R.string.expand_sheet);
                    }
                    break;

                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }


}
