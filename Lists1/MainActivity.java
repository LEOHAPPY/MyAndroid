package com.example.dkiong.lists;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemClickListener {

    List<Student> students;
    private void getData() {
        students = new ArrayList<Student>();
        students.add(new Student("Tan Ah Kow", 12, "Smart School"));
        students.add(new Student("Lim Ah Pin", 11, "Rich School"));
        students.add(new Student("Teo Wong Heng", 14, "Low School"));
        students.add(new Student("Ho Go Woo", 15, "River School"));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(new SimpleAdapter
                (this, students, R.layout.row,
                        new String[]{"name", "age"},
                        new int[]{ R.id.textView1, R.id.textView2}));
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id) {
        Student item = (Student) av.getAdapter().getItem(position);
        Toast.makeText(getApplicationContext(), item.get("name") + " selected",
                Toast.LENGTH_LONG).show();
    }

}

