package com.example.akty7.assignment03;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class InstructionActivity extends AppCompatActivity {
    TextView txtView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //TODO:Add instructions for this activity
        String str="Instructions: \n " +
                "This is a user registration app for students of COP290. " +
                "The students are required to put in their valid Entry Numbers along with their names." +
                "If there is any invalid entry, an error message specific to the invalid entry is shown. "+
                "Please avoid names greater than character length 16, as this the maximum size that the server will accept for user registration. "+
                "The names shouldn't contain numbers or special characters as that will be considered an invalid name.";
        txtView=(TextView) findViewById(R.id.textView);
        txtView.setText(str);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

}
