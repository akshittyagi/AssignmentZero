package com.example.akty7.assignment03;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;

public class ResponseActivity extends AppCompatActivity {

    TextView txtView=null;
    TextView txtView1=null;
    TextView txtView2=null;
    TextView txtView3=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        txtView=(TextView) findViewById(R.id.textView0);
        txtView1=(TextView) findViewById(R.id.textView1);
        txtView2=(TextView) findViewById(R.id.textView2);
        txtView3=(TextView) findViewById(R.id.textView3);

        txtView.clearComposingText();
        txtView1.clearComposingText();
        txtView2.clearComposingText();
        txtView3.clearComposingText();

        txtView.setText("");
        txtView1.setText("");
        txtView2.setText("");
        txtView3.setText("");


        Bundle bundle = getIntent().getExtras();
        String response=bundle.getString("Response");
        int responseCode=Integer.parseInt(response.substring(21, 22));

        if(responseCode==0)
        {
            String typeOfResponse=response.substring(45);
            response.replaceAll("[-+.^:,};]","");
            Toast.makeText(getApplicationContext(),typeOfResponse,Toast.LENGTH_LONG);
        }
        else if(responseCode==1)
        {
            String typeOfResponse=response.substring(45);
            response.replaceAll("[-+.^:,};]", "");
            Toast.makeText(getApplicationContext(), typeOfResponse, Toast.LENGTH_LONG);
            txtView.setText("Your team: " + bundle.getString("teamname") + " has successfully registered with us");
            txtView1.setText("Details of First Team Member: \n" +
                    "Name: " + bundle.getString("name1") + "\n" +
                    "Entry Number: " + bundle.getString("entry1"));
            txtView2.setText("Details of Second Team Member: \n" +
                    "Name: " + bundle.getString("name2") + "\n" +
                    "Entry Number: " + bundle.getString("entry2"));

            if(bundle.getBoolean("isThree"))
            {
                txtView3.setText("Details of Third Team Member: \n" +
                        "Name: " + bundle.getString("name3") + "\n" +
                        "Entry Number: " + bundle.getString("entry3"));
            }
            else
            {
                txtView3.setText("The team " + bundle.getString("teamname") + " has only 2 members");
            }

        }


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Returning to registration page", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent returnIntent=new Intent(ResponseActivity.this,MainActivity.class);
                startActivity(returnIntent);
                ResponseActivity.this.finish();
            }
        });
    }

}
