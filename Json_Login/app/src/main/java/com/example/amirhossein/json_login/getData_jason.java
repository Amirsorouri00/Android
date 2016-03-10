package com.example.amirhossein.json_login;
import android.os.AsyncTask;
import android.widget.EditText;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;import java.net.URLEncoder;
import java.nio.ByteBuffer;

import java.net.URLConnection;

/**
 * Created by Amir Hossein on 2/4/2016.
 */
public class getData_jason extends AsyncTask{

    String KholaseKQuery;
    String User;

    public getData_jason(String link,String user) {
        KholaseKQuery = link;
        User = user;
    }

    @Override
    protected String doInBackground(Object[] params) {

        try{
/*
            InputStream in;
            String qauryResult = null;
            URL db = new URL(KholaseKQuery);
            HttpURLConnection connect =(HttpURLConnection) db.openConnection();
            HttpURLConnection htpconection = (HttpURLConnection) connect;
            htpconection.setAllowUserInteraction(false);
            htpconection.connect();
            in = htpconection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(in);
            StringBuilder sb = new StringBuilder();
            BufferedReader bif = new BufferedReader(new InputStreamReader(htpconection.getInputStream()));
            String eline = "";
            while((eline = bif.readLine()) != null){
                sb.append(eline);
            }
            */
            /*String data = URLEncoder.encode("username", "UTF8")+"="+URLEncoder.encode(User,"UTF8");

            connect.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(connect.getOutputStream());
            wr.write(data);

            wr.flush();*/
            URL mylink = new URL(KholaseKQuery);

            URLConnection connect = mylink.openConnection();

            BufferedReader read = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            StringBuilder sB = new StringBuilder();
            String eline;
            while((eline = read.readLine())!= null)
            {
                sB.append(eline);
            }
            //MainActivity.jason_rs = sB.toString();
            MainActivity.result = sB.toString();
            MainActivity.is = true;
            JSONObject jObj;
            try{

                jObj = new JSONObject(MainActivity.result.replace("callback(","")).getJSONObject("response");
                JSONArray jsonArray = jObj.optJSONArray("Username");

                for (int i = 0;i < jsonArray.length();i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (/*jsonObject.getBoolean("ali")*/true){
                        MainActivity.jason_rs = jsonObject.optString("Name");
                        MainActivity.jason_rs = jsonObject.getString("Name");
                    }
                }
            }catch (Exception e){
            }
        }catch (Exception e){
            /*Any Exception Here*/
        }
        return "";
    }
}
