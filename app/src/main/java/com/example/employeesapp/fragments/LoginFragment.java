package com.example.employeesapp.fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employeesapp.Data.Data;
import com.example.employeesapp.Data.DataHelper;
import com.example.employeesapp.R;
import com.example.employeesapp.LoginScreen;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    @BindView(R.id.email)
    EditText emailText;
    @BindView(R.id.pass)
    EditText passText;

    //Login button
    @OnClick(R.id.log)
    public void Login(){
        String email = emailText.getText().toString();
        String pass = passText.getText().toString();
        if(!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)){
            if(checkUserData(email,pass)){
              Toast.makeText(getContext(), "Login successful", Toast.LENGTH_SHORT).show();
              ((LoginScreen)getActivity()).go();

          }else{
             Toast.makeText(getContext(), "Login failed", Toast.LENGTH_SHORT).show();
        }
      }
    }

    //go to Register fragment
    @OnClick(R.id.textView)
    public void reg(){
        ((LoginScreen)getActivity()).goToRegister();
    }

    // Required empty public constructor
    public LoginFragment() { }

    //Call database
    private boolean checkUserData(String email, String pass) {
        DataHelper dbHelper = new DataHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(Data.TABLE_NAME1, new String[]{Data.COL_USR_ID, Data.COL_USR_NAME, Data.COL_USR_PASS}, Data.COL_USR_NAME + "='" + email + "' and " + Data.COL_USR_PASS + "='" + pass + "'", null, null, null, null);
        return cursor.moveToNext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


}
