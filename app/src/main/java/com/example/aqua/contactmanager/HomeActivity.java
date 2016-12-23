package com.example.aqua.contactmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import io.realm.Realm;
import io.realm.RealmResults;

public class HomeActivity extends AppCompatActivity {
        RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView= (RecyclerView) findViewById(R.id.recyclerviewrv);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(HomeActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //get all contact from realm
        Realm.init(HomeActivity.this);
        RealmResults<Contact> results=ContactDAO.select();
        RecyclerviewAdapter adapter=new RecyclerviewAdapter(results,HomeActivity.this);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newContactIntent=new Intent(HomeActivity.this,NewContactActivity.class);
                startActivity(newContactIntent);

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       switch (id) {
           case R.id.option1:
               Intent updateContactIntent=new Intent(HomeActivity.this,UpdateContactActivity.class);
               startActivity(updateContactIntent);

               break;
           case R.id.option2:
               Intent deleteContactIntent=new Intent(HomeActivity.this,DeleteContactActivity.class);
               startActivity(deleteContactIntent);

               break;
           case R.id.option3:
               finish();
               break;
           case R.id.option4:
               break;
        }

        return super.onOptionsItemSelected(item);
    }
}
