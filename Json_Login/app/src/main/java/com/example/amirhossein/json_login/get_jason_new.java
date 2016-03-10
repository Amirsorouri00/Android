package com.example.amirhossein.json_login;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Amir Hossein on 2/13/2016.
 */
public class get_jason_new extends AsyncTask {
    String url;
    String data;

    public get_jason_new(String s, String amir) {
        url = s;
        data = amir;
    }

    @Override
    protected String doInBackground(Object[] params) {
        // Creating service handler class instance
        ServiceHandler sh = new ServiceHandler();

        // Making a request to url and getting response
        String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

        Log.d("Response: ", "> " + jsonStr);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                MainActivity.is = true;
                // Getting JSON Array node
                MainActivity.contacts = jsonObj.getJSONArray(MainActivity.TAG_CONTACTS);

                // looping through All Contacts
                for (int i = 0; i < MainActivity.contacts.length(); i++) {
                    JSONObject c = MainActivity.contacts.getJSONObject(i);

                    String id = c.getString(MainActivity.TAG_ID);
                    String name = c.getString(MainActivity.TAG_NAME);
                    String email = c.getString(MainActivity.TAG_EMAIL);
                    String address = c.getString(MainActivity.TAG_ADDRESS);
                    String gender = c.getString(MainActivity.TAG_GENDER);

                    // Phone node is JSON Object
                    JSONObject phone = c.getJSONObject(MainActivity.TAG_PHONE);
                    String mobile = phone.getString(MainActivity.TAG_PHONE_MOBILE);
                    String home = phone.getString(MainActivity.TAG_PHONE_HOME);
                    String office = phone.getString(MainActivity.TAG_PHONE_OFFICE);

                    // tmp hashmap for single contact
                    HashMap<String, String> contact = new HashMap<String, String>();

                    // adding each child node to HashMap key => value
                    contact.put(MainActivity.TAG_ID, id);
                    contact.put(MainActivity.TAG_NAME, name);
                    contact.put(MainActivity.TAG_EMAIL, email);
                    contact.put(MainActivity.TAG_PHONE_MOBILE, mobile);

                    // adding contact to contact list
                    MainActivity.contactList.add(contact);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("ServiceHandler", "Couldn't get any data from the url");
        }

        return null;
    }
}

/*    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        // Dismiss the progress dialog
        if (pDialog.isShowing())
            pDialog.dismiss();
        /**
         * Updating parsed JSON data into ListView
         * */
     /*   ListAdapter adapter = new SimpleAdapter(
                MainActivity.this, contactList,
                R.layout.list_item, new String[] { TAG_NAME, TAG_EMAIL,
                TAG_PHONE_MOBILE }, new int[] { R.id.name,
                R.id.email, R.id.mobile });

        setListAdapter(adapter);
    }
*/


