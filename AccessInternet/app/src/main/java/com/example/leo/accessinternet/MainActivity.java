package com.example.leo.accessinternet;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);  //

        new AsyncTask<Void, Void, List<String>>() {
            @Override
            protected List<String> doInBackground(Void... params) {
                return Employee.list();
            }
            @Override
            protected void onPostExecute(List<String> result) {
                MyAdapter adapter = new MyAdapter(MainActivity.this, R.layout.row, result);
                setListAdapter(adapter);
            }
        }.execute();
//
//        List<String> emps = Employee.list();
//        MyAdapter adapter = new MyAdapter(this, R.layout.row, emps);  //only diffrents is pramiter only customeize the layout
////1\ call row layout which has textview and imageVie
////2\ goto adaptor
//
////    adaptor    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, //give data to  string adapter
////                android.R.layout.simple_list_item_1, emps);
//        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Intent intent = new Intent(this, EmpDetailsActivity.class);
        intent.putExtra("eid", item);  //pass id
        startActivity(intent);
    }
}
