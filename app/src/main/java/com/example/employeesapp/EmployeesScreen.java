package com.example.employeesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.employeesapp.Data.Data;

import java.util.Date;
import java.util.jar.Attributes;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EmployeesScreen extends AppCompatActivity {

    @BindView(R.id.empN)
    TextView Name;
    @BindView(R.id.empR)
    TextView Role;
    @BindView(R.id.empS)
    TextView Salary;
    @BindView(R.id.empD)
    TextView Date;
    @BindView(R.id.empAd)
    TextView Address;
    @BindView(R.id.empG)
    TextView Gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees_screen);
        ButterKnife.bind(this);
        getIntentExtras();
    }

    private void getIntentExtras() {
        if(getIntent().hasExtra("getName")&&getIntent().hasExtra("getRole")){
            String name,role,salary,date,address,gender;
            name=getIntent().getStringExtra("getName");
            role=getIntent().getStringExtra("getRole");
            salary=getIntent().getStringExtra("getSalary");
            date=getIntent().getStringExtra("getBirthDate");
            address=getIntent().getStringExtra("getAddress");
            gender=getIntent().getStringExtra("getGender");
            Name.setText(name);
            Role.setText(role);
            Salary.setText(salary);
            Date.setText(date);
            Address.setText(address);
            Gender.setText(gender);

        }
    }
}
