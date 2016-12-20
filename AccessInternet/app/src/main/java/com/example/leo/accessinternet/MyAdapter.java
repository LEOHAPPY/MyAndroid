package com.example.leo.accessinternet;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by leo on 19/12/16.
 */
/*Adaptor work for a certain ListItem*/
public class MyAdapter extends ArrayAdapter<String> {

    private List<String> items;
    int resource; //layout

    public MyAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.resource = resource;  //for every row
         this.items = items;
    }

    @Override  //?time to form list/row adapter for list ot use
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);  //inflator take layout
        final String eid = items.get(position);
        if (eid != null) {
            TextView e = (TextView) v.findViewById(R.id.textView); //hold id
            e.setText(eid);
            //set
            final ImageView image = (ImageView) v.findViewById(R.id.imageView2); //hold tomnier of the pic
//            image.setImageBitmap(Employee.getPhoto(false, eid));  //change pic biger - false

//            Bitmap b = Employee.getPhoto(false,eid);
//
//            image.setImageBitmap(b);


            new AsyncTask<Void, Void, Bitmap>() {
                @Override
                protected Bitmap doInBackground(Void... params) {
                    return Employee.getPhoto(false,eid);
                }
                @Override
                protected void onPostExecute(Bitmap result) {
                    image.setImageBitmap(result);
                }
            }.execute();
            //set
        }//what you have in the row
        //evevry things else is generic based on that your layout is definde
        return v;  //return this view have in side is filled above
    }
}
