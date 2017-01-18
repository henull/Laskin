package com.laskin.henull.laskin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Laskin.EXTRA_MESSAGE);
        TextView tv = (TextView) findViewById(R.id.aboutTextBox);
        tv.setTextSize(30);
        tv.setText(message);
    }
}
