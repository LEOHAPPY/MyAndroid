package com.example.leo.listingactivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListingActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleAdapter adap = new SimpleAdapter(this, Item.getParts(),
                android.R.layout.simple_list_item_2,
                new String[]{"id","description"},
                new int[]{android.R.id.text1,android.R.id.text2});
        setListAdapter(adap);

        //how many default textview have only two?
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Item s = (Item) getListAdapter().getItem(position);
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("item", s);
        startActivity(intent);
    }
}