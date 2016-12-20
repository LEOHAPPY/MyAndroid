package com.example.leo.mylist2test;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by leo on 19/12/16.
 */

public class NewsItem  extends HashMap<String, String> {
    /**
     * NewsItem model
     */
    public NewsItem(String area, String title, String url) {
        put("area", area);
        put("title", title);
        put("url", url);
    }

    public static List<NewsItem> jread() {
        List<NewsItem> list = new ArrayList<NewsItem>();
        JSONArray a = JSONParser.getJSONArrayFromUrl("http://dkiong.no-ip.biz/site/news?json");
        try {
            for (int i = 0; i < a.length(); i++) {
                JSONObject b = a.getJSONObject(i);
                list.add(new NewsItem(b.getString("area"), b.getString("title"),
                        b.getString("url")));
            }
        } catch (Exception e) {
            Log.e("NewsItem", "JSONArray error");
        }
        return (list);
    }
}

//    public static List<NewsItem> read() {
//        List<NewsItem> list = new ArrayList<NewsItem>();
//        try {
//            URL url = new URL("http://dkiong.no-ip.bizsite/news/");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.connect();
//            InputStream inp = conn.getInputStream();
//            BufferedReader rd = new BufferedReader(new InputStreamReader(inp));
//            String area;
//            while ((area = rd.readLine()) != null) {
//                String title = rd.readLine();
//                String u = rd.readLine();
//                list.add(new NewsItem(area, title, u));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return (list);
//    }

//http file reader