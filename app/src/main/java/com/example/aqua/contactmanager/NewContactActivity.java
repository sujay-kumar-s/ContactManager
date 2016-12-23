package com.example.aqua.contactmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;

public class NewContactActivity extends AppCompatActivity {
    EditText nameet;
    EditText phoneet;
    EditText emailet;
    EditText addresset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nameet= (EditText) findViewById(R.id.nameet);
        phoneet=(EditText) findViewById(R.id.phoneet);
        emailet=(EditText) findViewById(R.id.emailet);
        addresset=(EditText) findViewById(R.id.addresset);





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=nameet.getText().toString();
                String phone=phoneet.getText().toString();
                String email=emailet.getText().toString();
                String address=addresset.getText().toString();

                Realm.init(NewContactActivity.this);
               boolean insertflag= ContactDAO.insert(name,phone,email,address);
                if(insertflag==true) {
                    Snackbar.make(view, "Contact Saved", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    Snackbar.make(view, "Failed to save contact", Snackbar.LENGTH_LONG).show();

                }
            }
        });
    }

}
