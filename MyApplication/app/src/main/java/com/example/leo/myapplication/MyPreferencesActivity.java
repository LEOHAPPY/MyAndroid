package com.example.leo.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences pref;
    EditText t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_preferences);
        pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        t1 = (EditText) findViewById(R.id.editText1);
        t1.setText(pref.getString("firstname", "null"));
        t2 = (EditText) findViewById(R.id.editText2);
        t2.setText(pref.getString("lastname", "null"));
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(this);

        Button b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                //finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("firstname", t1.getText().toString());
        editor.putString("lastname", t2.getText().toString());
        editor.commit();
        //finish();
    }

    public void Go(View view) {
        Intent go = new Intent(this,finishTestActivity.class);
        startActivity(go);
        //finish();
    }


    public void InvokePreXML(View view) {
        Intent invoke = new Intent(this,MyPreferenceActivity.class);
        startActivity(invoke);
        //finish();
    }


}
