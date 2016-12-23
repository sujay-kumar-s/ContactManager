package com.example.aqua.contactmanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;

public class DeleteContactActivity extends AppCompatActivity {
    EditText nameet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            nameet= (EditText) findViewById(R.id.nameet);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Realm.init(DeleteContactActivity.this);
                boolean deleteflag=ContactDAO.delete(nameet.getText().toString());
                if(deleteflag==true) {
                    Snackbar.make(view, "Contact Deleted", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    Snackbar.make(view, "Failed to delete contact", Snackbar.LENGTH_LONG).show();

                }
            }
        });
    }

}
