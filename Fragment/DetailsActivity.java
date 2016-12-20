package com.example.dkiong.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class DetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        if (intent.hasExtra("details")) {
            HashMap<String, String> m = (HashMap<String,String>)intent.getSerializableExtra("details");
            Bundle args = new Bundle();
            args.putSerializable("item", m);
            Fragment f = new DetailsFragment();
            f.setArguments(args);
            getFragmentManager().beginTransaction()
                    .add(R.id.detailsframe2, f)
                    .commit();
        }

    }
}
