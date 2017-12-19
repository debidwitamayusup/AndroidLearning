package com.example.debi.androidlearning;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        TextView tvUsername = (TextView) findViewById(R.id.tvUsername);

        String username = getIntent().getStringExtra("username");

        tvUsername.setText(username);
    }
}
