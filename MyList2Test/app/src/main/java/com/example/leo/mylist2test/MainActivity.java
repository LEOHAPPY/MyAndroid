package com.example.leo.mylist2test;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;

public class MainActivity extends ListActivity {

    //no need to care about the activity_main.xml
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        List<NewsItem> news = NewsItem.jread();
        SimpleAdapter adapter = new SimpleAdapter(this, news,
                android.R.layout.simple_list_item_2,
                new String[]{"title", "area"},
                new int[]{ android.R.id.text1, android.R.id.text2});
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        NewsItem item = (NewsItem) getListAdapter().getItem(position);
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(item.get("url")));
        startActivity(i);
    }
}
