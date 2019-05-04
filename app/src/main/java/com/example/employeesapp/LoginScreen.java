
package com.example.employeesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.employeesapp.Util.SharedUtils;
import com.example.employeesapp.fragments.LoginFragment;
import com.example.employeesapp.fragments.RegisterFragment;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //stop loginScreen
        final boolean login = SharedUtils.getUserSession(this);
        if (login==true){
            startActivity(new Intent(LoginScreen.this, HomeScreen.class));
            finish();
        }
    //setup base fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new LoginFragment()).commit();
    }

    public void goToRegister(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new RegisterFragment()).commit();

    }

    public void goToLogin(){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new LoginFragment()).commit();

    }
    public void go(){
        SharedUtils.saveUserSession(this,true);
        Intent i = new Intent(LoginScreen.this, HomeScreen.class);
        startActivity(i);
        finish();
    }

}
