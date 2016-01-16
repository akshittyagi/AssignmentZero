package com.example.akty7.assignment03;

import android.net.Uri;
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
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    //TODO: Make an Icon and a start/loading page
    Button btn = null;
    EditText editTxt = null;
    EditText editTxt2 = null;
    EditText editTxt3 = null;
    EditText editTxt4 = null;
    EditText editTxt5 = null;
    EditText editTxt6 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //all editTexts initialized and set for onClick clearing
        editTxt = (EditText) findViewById(R.id.editText);
        editTxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                editTxt.getText().clear();
            }
        });

        editTxt2 = (EditText) findViewById(R.id.editText2);
        editTxt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                editTxt2.getText().clear();
            }
        });

        editTxt3 = (EditText) findViewById(R.id.editText3);
        editTxt3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                editTxt3.getText().clear();
            }
        });

        editTxt4 = (EditText) findViewById(R.id.editText4);
        editTxt4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                editTxt4.getText().clear();
            }
        });

        editTxt5 = (EditText) findViewById(R.id.editText5);
        editTxt5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                editTxt5.getText().clear();
            }
        });

        editTxt6 = (EditText) findViewById(R.id.editText6);
        editTxt6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                editTxt6.getText().clear();
            }
        });

        //for debugging if FAB fails
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String[] str = new String[7];
                str[0]= editTxt.getText().toString();
                str[1]= editTxt2.getText().toString();
                str[2]= editTxt3.getText().toString();
                str[3]= editTxt4.getText().toString();
                str[4]= editTxt5.getText().toString();
                str[5]= editTxt5.getText().toString();
                str[6]= editTxt6.getText().toString();
                sendResult(str);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] str = new String[7];
                str[0]= editTxt.getText().toString();
                str[1]= editTxt2.getText().toString();
                str[2]= editTxt3.getText().toString();
                str[3]= editTxt4.getText().toString();
                str[4]= editTxt5.getText().toString();
                str[5]= editTxt5.getText().toString();
                str[6]= editTxt6.getText().toString();
                //TODO: Add the check for valid entry numbers and names in editTexts
                if(checkValidity(str);
                {
                    sendResult(str);
                }


            }
        });

    }

    public boolean checkValidity(String[] str)
    {//returns the validity and also points out the error in the input
        //TODO: Create checking and add a UI feature for pointing out the error

    }

    public void sendResult(final String[] str){
        // Test for function call
        Snackbar.make(getCurrentFocus(), "Sending Data to server", Snackbar.LENGTH_LONG).show();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://agni.iitd.ernet.in/cop290/assign0/register/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Snackbar.make(getCurrentFocus(), "Error sending data to server", Snackbar.LENGTH_LONG).show();
            }
        }){
            //function for packing data and sending to server in JSON HashMap
            @Override
            protected Map<String,String> getParams()
            {
                String[] strToBePut=str;
                Map<String,String> params =new HashMap<String,String>();
                params.put("teamname", strToBePut[0]);
                params.put("entry1", strToBePut[1]);
                params.put("name1", strToBePut[2] );
                params.put("entry2", strToBePut[3]);
                params.put("name2", strToBePut[4]);
                params.put("entry3", strToBePut[5]);
                params.put("name3", strToBePut[6]);
                return params;
            }

        };
        //queue all requests
        queue.add(stringRequest);
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }
}