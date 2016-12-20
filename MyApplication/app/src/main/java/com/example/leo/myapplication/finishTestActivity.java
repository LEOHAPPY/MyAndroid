package com.example.leo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class finishTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_test);
    }

    public void goback(View view) {
        Intent goback = new Intent(this,MyPreferencesActivity.class);
        startActivity(goback);
        //finish();
    }

    public void forward(View view) {
        Intent forward = new Intent(this, finishTestActivity2.class);
        startActivity(forward);
        //finish();
    }

}
