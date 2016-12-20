package com.example.dkiong.demo1;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox checkbox1;
    EditText text;
    Button button1, button2;

    void append(String m) {
        text.append(m+"\n");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText1);
        // make anonymous object as listener
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                append("button Clicked");
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });
        // make activity as listener
        checkbox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkbox1.setOnClickListener(this);
        registerForContextMenu(text);
        registerForContextMenu(button1);
    }

    @Override
    public void onClick(View v) {
        append("checkbox changed: "+checkbox1.isChecked());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                new AlertDialog.Builder(this)
                        .setTitle("Change settings")
                        .setMessage("Are you sure you want to change settings?")
                        .setCancelable(false)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, getString(R.string.sayyes), Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, getString(R.string.sayno), Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
                return true;
            case R.id.item2:
                final AppCompatDialog d = new AppCompatDialog(this);
                d.setTitle(getString(R.string.customdialogtitle));
                d.setContentView(R.layout.customdialog);
                d.setCancelable(false);
                TextView t = (TextView) d.findViewById(R.id.textView);
                t.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });
                d.show();
                return true;
            case R.id.item3:
                final ProgressDialog p = new ProgressDialog(this);
                p.setTitle("Heavy Work");
                p.setMessage("Please wait ...");
                p.setCancelable(true);
                p.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                p.setMax(50); //the visualable process number
                // simulate long-running work
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            for (int i=0; i<10; i++) {
                                Thread.sleep(500);
                                p.setProgress(i);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        p.dismiss();
                    }
                }.start();
                p.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        if (v == text)
            inflater.inflate(R.menu.context, menu);
        else if (v == button1)
            inflater.inflate(R.menu.context2, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.context1:
                Log.i("Menu", "context1");
                return true;
            case R.id.context2:
                Log.i("Menu", "context2");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
