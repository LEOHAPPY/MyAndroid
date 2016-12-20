package com.example.leo.accessinternet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by leo on 19/12/16.
 */

public class Employee extends HashMap<String, String> {

    final static String baseURL = "http://dkiong.no-ip.biz/site/emp";
    //["E45008", "L68221", "S71208", "B00001"]

    public Employee(String name, String eid, String department, String address) {
        put("name", name);
        put("eid", eid);
        put("department", department);
        put("address", address);
    }

    public static List<String> list() {
        List<String> list = new ArrayList<String>();
        JSONArray a = JSONParser.getJSONArrayFromUrl(baseURL);
        try {
            for (int i =0; i<a.length(); i++)
                list.add(a.getString(i));
        } catch (Exception e) {
            Log.e("Employee.list()", "JSONArray error");
        }
        return(list);
    }

    public static Employee getEmp(String eid) {
        JSONObject b = JSONParser.getJSONFromUrl(baseURL + "/" + eid);
        try {
            return new Employee(b.getString("name"), b.getString("eid"),
                    b.getString("department"), b.getString("address"));
            //return new Employee(name,eid,department,address)
        } catch (Exception e) {
            Log.e("Employee.getEmp()", "JSONArray error");
        }
        return(null);  //why here need to return null
    }

    final static String imageURL = "http://dkiong.no-ip.biz/images";
    public static Bitmap getPhoto(boolean thumbnail, String eid) {
        try {
            URL url = (thumbnail ? new URL(String.format("%s/small-%s.jpg",imageURL, eid)) : //small || larger one
                    new URL(String.format("%s/%s.jpg",imageURL, eid)));
            URLConnection conn = url.openConnection();
            InputStream ins = conn.getInputStream();  //sequenc of byes
            Bitmap bitmap = BitmapFactory.decodeStream(ins);  //convert to bitmap  as log as get url can retive it
            ins.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Employee.getPhoto()", "Bitmap error");
        }
        return(null);
    }
}
