package com.example.amirhossein.json_login;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // JSON Node names
    public static final String TAG_CONTACTS = "contacts";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_ADDRESS = "address";
    public static final String TAG_GENDER = "gender";
    public static final String TAG_PHONE = "phone";
    public static final String TAG_PHONE_MOBILE = "mobile";
    public static final String TAG_PHONE_HOME = "home";
    public static final String TAG_PHONE_OFFICE = "office";
    public static String result;
    public static boolean is = false;
    public static JSONArray contacts = null;


    // Hashmap for ListView
    public static ArrayList<HashMap<String, String>> contactList;


    public static String res = "";
    public static String jason_rs = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        new getData_Html("http://test.kholaseketab.ir/amir/php.php","ali").execute();

        Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG).show();
            }
        });
        new getData_jason("http://test.kholaseketab.ir/amir/json.php","amir").execute();

        Button btn2 = (Button)findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(true){
                    Toast.makeText(getApplicationContext(), "Yes", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), jason_rs, Toast.LENGTH_LONG).show();
                    EditText et = (EditText)findViewById(R.id.editText);
                    et.setText(result, TextView.BufferType.EDITABLE);
                }
                else{
                    Toast.makeText(getApplicationContext(), "No", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(), jason_rs, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
