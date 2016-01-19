package com.example.akty7.assignment03;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        Bundle bundle = getIntent().getExtras();
        String response=bundle.getString("Response");

        //TODO:Detect response code from server and act accordingly

//        if(responseCode==0)
//        {
//            String typeOfResponse=response.substring(45);
//            response.replaceAll("[-+.^:,};]","");
//            Toast.makeText(getApplicationContext(),typeOfResponse,Toast.LENGTH_LONG);
//        }
//
//        Toast.makeText(getApplicationContext(),response.substring(21,22),Toast.LENGTH_LONG).show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Returning to registration page", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
