package com.example.leo.listingactivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class DetailsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        Bundle b = getIntent().getExtras();
        HashMap<String,String> item = (HashMap<String,String>) b.get("item");
        TextView t2 = (TextView) findViewById(R.id.textView2);
        t2.setText(item.get("id"));
        TextView t4 = (TextView) findViewById(R.id.textView4);
        t4.setText(item.get("description"));
        TextView t6 = (TextView) findViewById(R.id.textView6);
        t6.setText(item.get("cost"));
    }
}
