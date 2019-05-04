package com.example.employeesapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import com.example.employeesapp.Data.Data;
import com.example.employeesapp.Data.DataHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddEmployeesScreen extends AppCompatActivity {
    private  DataHelper DH ;
    private SQLiteDatabase db;

    @BindView(R.id.name)
    EditText EntNAme;
    @BindView(R.id.role)
    EditText EntRole;
    @BindView(R.id.address)
    EditText EntAdress;
    @BindView(R.id.date)
    EditText EntDate;
    @BindView(R.id.salary)
    EditText EntSalary;
    @BindView(R.id.gender)
    EditText EntGender;

    //save button
    @OnClick(R.id.save)
    public void save(){
    String name=EntNAme.getText().toString();
    String role=EntRole.getText().toString();
    String address=EntAdress.getText().toString();
    String date=EntDate.getText().toString();
    String gender=EntGender.getText().toString();
    String salary=EntSalary.getText().toString();
    //Check EditText Not Empty And Save
    if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(role)&&!TextUtils.isEmpty(gender)&&!TextUtils.isEmpty(salary)){

            if(DH.saveEmployees(name,role,address,date,gender,salary)){
                Toast.makeText(this, "Employees Saved", Toast.LENGTH_SHORT).show();
                EntSalary.setText(null);
                EntNAme.setText(null);
                EntDate.setText(null);
                EntAdress.setText(null);
                EntGender.setText(null);
                EntRole.setText(null);
            }
        }
    }

    //Cancel button
    @OnClick(R.id.cancel)
    public void cancel(){
        startActivity(new Intent(AddEmployeesScreen.this,HomeScreen.class));
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employees_screen);
        ButterKnife.bind(this);
        //Write On Database
         DH=new DataHelper(this);

    }
}
