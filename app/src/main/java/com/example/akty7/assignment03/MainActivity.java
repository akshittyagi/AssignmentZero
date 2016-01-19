package com.example.akty7.assignment03;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.Image;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.lang.*;


public class MainActivity extends AppCompatActivity {

    //TODO: Make an Icon and a start/loading page
    Button btn = null;
    EditText editTxt = null;
    EditText editTxt2 = null;
    EditText editTxt3 = null;
    EditText editTxt4 = null;
    EditText editTxt5 = null;
    EditText editTxt6 = null;
    EditText editTxt7 = null;
    Boolean are3 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //all editTexts initialized and set for onClick clearing
        //for debugging if FAB fails
        editTxt6 = (EditText) findViewById(R.id.editText6);
        editTxt7 = (EditText) findViewById(R.id.editText7);
        editTxt6.setEnabled(false);
        editTxt7.setEnabled(false);

        CheckBox chk = (CheckBox) findViewById(R.id.checkBox);


        chk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //is chkIos checked?
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(MainActivity.this,
                            "Bro, awesome :)", Toast.LENGTH_LONG).show();
                    editTxt6 = (EditText) findViewById(R.id.editText6);
                    editTxt7 = (EditText) findViewById(R.id.editText7);
                    editTxt6.setEnabled(true);
                    editTxt7.setEnabled(true);
                    are3 = true;
                }
                if (!((CheckBox) v).isChecked()) {
                    Toast.makeText(MainActivity.this,
                            "Aww :(", Toast.LENGTH_LONG).show();
                    editTxt6 = (EditText) findViewById(R.id.editText6);
                    editTxt7 = (EditText) findViewById(R.id.editText7);
                    editTxt6.setEnabled(false);
                    editTxt7.setEnabled(false);
                    are3=false;
                }

            }
        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

                editTxt7 = (EditText) findViewById(R.id.editText7);
                editTxt7.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v)
                    {
                        editTxt6.getText().clear();
                    }
                });


                final String[] str = new String[7];
                str[0]= editTxt.getText().toString();
                str[1]= editTxt2.getText().toString();
                str[2]= editTxt3.getText().toString();
                str[3]= editTxt4.getText().toString();
                str[4]= editTxt5.getText().toString();
                str[5]= editTxt6.getText().toString();
                str[6]= editTxt7.getText().toString();
                if(checkValidity(str))
                {
                    sendResult(str,are3);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid Entry",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public boolean checkValidity(String[] str)
    {//returns the validity and also points out the error in the whole input
        boolean check1=true,check2=check1,check3=check1,check4=check1,check5=check1,check6=check1,check7=check1;
        Drawable errorIcon = getResources().getDrawable(R.drawable.erroricon);
        //TODO:Check and set bounds for error icon
        errorIcon.setBounds(new Rect(0,0,errorIcon.getIntrinsicWidth()/10,errorIcon.getIntrinsicHeight()/10));
        if(str[0].length() == 0)
        {
            editTxt.setError("Enter Team Name",errorIcon);
            check1 =  false;
        }
        if(!checkValidityName(str[1]))
        {
            editTxt2.setError("Enter Valid Student Name",errorIcon);
            check2 =  false;
        }
        if(!checkValidityEntryNumber(str[2]))
        {
            editTxt3.setError("Enter Valid Entry Number",errorIcon);
            check3 =  false;
        }
        if(!checkValidityName(str[3]))
        {
            editTxt4.setError("Enter Valid Student Name",errorIcon);
            check4 =  false;
        }
        if(!checkValidityEntryNumber(str[4]))
        {
            editTxt5.setError("Enter Valid Entry Number",errorIcon);
            check5 =  false;
        }
        if(!checkValidityName(str[5]))
        {
            editTxt6.setError("Enter Valid Student Name",errorIcon);
            check6 =  false;
        }
        if(!checkValidityEntryNumber(str[6]))
        {
            editTxt7.setError("Enter Valid Entry Number",errorIcon);
            check7 = false;
        }

        return (check1 && check2 && check3 && check4 && check5 && check6 && check7);

    }

    public boolean checkValidityEntryNumber(String str)
    {
        //returns the validity and also points out the error in the input of Entry numbers
        if(str.length() == 0) return false;
        String[] Courses = {"BB1", "BB5", "CE1", "CH1", "CH7", "CS1", "CS5", "ME1", "EE1", "EE3", "EE5", "ME2", "MT1", "MT5", "MT6", "PH1", "TT1"};
            boolean check1  = false;
            boolean check2 = false;
            boolean check3 = false;
            boolean check4 = false;
            if(str.length()!=11)
            {
                return false;
            }
            int year;
            try {
                year = Integer.parseInt(str.substring(0, 4));
            }
            catch(NumberFormatException e)
            {
                return false;
            }

            String program = str.substring(4, 7);
            String zero = str.substring(7, 8);

            int serialNumber;
            try {
                serialNumber = Integer.parseInt(str.substring(8));
            }
            catch(NumberFormatException e)
            {
                return false;
            }

            if (year >= 2008 && year <= 2014) check1 = true;
            for (String course : Courses) {
                if (course.equalsIgnoreCase(program)) {
                    check2 = true;
                    break;
                }
            }

            if (zero.equals("0")) check3 = true;
            if (serialNumber > 0 && serialNumber < 1000) check4 = true;

            return check1 && check2 && check3 && check4;
    }



    public boolean checkValidityName(String str)
    {//returns the validity and also points out the error in the input of Names excluding Team Name
        if(str.length() == 0)
            return false;
        char[] characters = str.toCharArray();
        for(char character : characters)
        {
            if(!Character.isLetter(character) && character != ' ') return false;
        }
        return true;
    }

    public void sendResult(final String[] str, final boolean isThreeMemberedTeam){
        // Test for function call
        Snackbar.make(getCurrentFocus(), "Sending Data to server", Snackbar.LENGTH_LONG).show();
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://agni.iitd.ernet.in/cop290/assign0/register/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                Intent responseIntent=new Intent(MainActivity.this,ResponseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("teamname", str[0]);
                bundle.putString("entry1", str[1]);
                bundle.putString("name1", str[2] );
                bundle.putString("entry2", str[3]);
                bundle.putString("name2", str[4]);
                bundle.putString("entry3", str[5]);
                bundle.putString("name3", str[6]);
                bundle.putString("Response",response);
                bundle.putBoolean("isThree", isThreeMemberedTeam);
                responseIntent.putExtras(bundle);
                startActivity(responseIntent);
                MainActivity.this.finish();
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