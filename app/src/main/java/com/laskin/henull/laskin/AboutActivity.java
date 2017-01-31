package com.laskin.henull.laskin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Laskin.EXTRA_MESSAGE);
        TextView tv = (TextView) findViewById(R.id.aboutTextBox);
        tv.setTextSize(30);
        tv.setText(message);

        EditText et = (EditText) findViewById(R.id.dateTextBox);
        Calendar c = Calendar.getInstance();
        et.setText(c.getTime().toString());
    }
}
