package com.example.amirhossein.database;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * Created by Amir Hossein on 1/31/2016.
 */
public class getData extends AsyncTask {

    private String Link="";
    private String User="";
    public getData(String link,String user){
        Link = link;
        User = user;
    }

    @Override
    protected String doInBackground(Object[] params) {

        try{

            String data = URLEncoder.encode("username", "UTF8")+"="+URLEncoder.encode(User,"UTF8");

            URL mylink = new URL(Link);
            URLConnection connect = mylink.openConnection();

            connect.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(connect.getOutputStream());
            wr.write(data);
            wr.flush();

            BufferedReader read = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            StringBuilder sB = new StringBuilder();
            String eline = "";

            while((eline = read.readLine())!= null)
            {
                sB.append(eline);
            }

            MainActivity.res = sB.toString();

        }catch (Exception e) {

        }
        return "";
    }
}



/* this is a substitution for getting input from database
 HttpResponse response = httpClient.execute(httpPost);

BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));

StringBuilder sb = new StringBuilder();

String line;
while ((line = reader.readLine()) != null)
    {
    sb = sb.append(line);
    }

String jsonText =  sb.toString();
 */
