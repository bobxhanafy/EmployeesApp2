package com.example.employeesapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.employeesapp.Adabter.EmpAdabter;
import com.example.employeesapp.Data.DataHelper;
import com.example.employeesapp.Model.EmpModel;
import com.example.employeesapp.Util.SharedUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeScreen extends AppCompatActivity {
    private DataHelper dh ;
    private SQLiteDatabase db;
    RecyclerView recyclerView;
    EmpAdabter empAdabter;
    List<EmpModel> empModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        recyclerView= findViewById(R.id.Rv);
        empModel=new ArrayList<EmpModel>();
        dh=new DataHelper(this);
        empModel=dh.getData();
        empAdabter=new EmpAdabter(empModel);
        //setup RecyclerView
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(empAdabter);


        setSupportActionBar(toolbar);
        //go to Add Employees Screen
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeScreen.this,AddEmployeesScreen.class));
            }
        });

    }
    //Logout item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.log_out,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SharedUtils.saveUserSession(this,false);
        startActivity(new Intent(HomeScreen.this,LoginScreen.class));
        finish();
        return true;
    }

}
