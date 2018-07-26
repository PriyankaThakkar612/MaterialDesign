package com.mymaterialdesigndemo.ui;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.mymaterialdesigndemo.R;

public class TextFieldActivity extends AppCompatActivity {


    EditText name;
    TextInputLayout inputLayoutName;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_field);
        setTitle(R.string.text_field);
        init();
    }

    private void init() {
        inputLayoutName = findViewById(R.id.tv_input_name);
        name = findViewById(R.id.et_input_name);
        btnLogin = findViewById(R.id.btn_login);

    }
}
