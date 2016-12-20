package com.example.dkiong.intents;

import android.os.Bundle;
import android.app.Activity;
import android.test.suitebuilder.TestMethod;
import android.widget.EditText;
import android.widget.TextView;

public class OnKeyListener extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_key_listener);
    }

    EditText mEditText = (EditText) findViewById(R.id.editText2);
    TextView mTextView = (TextView) findViewById(R.id.textView2);



}
