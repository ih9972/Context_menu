package com.example.contextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent gi2 = getIntent();
    }

    /**
     * this method closes the activity
     * @param view
     */
    public void return_from_credit(View view) {
        finish();
    }
}