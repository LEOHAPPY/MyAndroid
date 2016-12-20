package com.example.leo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class finishTestActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test2);
    }

    public void GoBackTo(View view) {
        Intent goback = new Intent(this, finishTestActivity.class);
        startActivity(goback);
        finish(); //distory the current acitivity that cannot go back to the corrisponding View directly
    }
}
