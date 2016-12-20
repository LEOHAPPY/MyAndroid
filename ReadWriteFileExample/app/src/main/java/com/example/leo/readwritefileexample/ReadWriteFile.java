package com.example.leo.readwritefileexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReadWriteFile extends AppCompatActivity {

    EditText txt1, txt2;
    final String filename = "abc.txt";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_write_file);
        txt1 = (EditText) findViewById(R.id.editText1);
        txt2 = (EditText) findViewById(R.id.editText2);
    }

    public void Write(View v) {
        String contents = txt1.getText().toString();
        try {
            FileOutputStream f = openFileOutput(filename, Context.MODE_PRIVATE);
            PrintWriter w = new PrintWriter(f);
            w.println(contents);
            w.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Read(View v) {
        StringBuilder buf = new StringBuilder();
        try {
            FileInputStream fos = openFileInput(filename);
            BufferedReader r = new BufferedReader(new InputStreamReader(fos));
            String s;
            while ((s = r.readLine()) != null) {
                buf.append(s);
                buf.append("\r\n");
            }
            r.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        txt2.setText(buf.toString());
    }
}
