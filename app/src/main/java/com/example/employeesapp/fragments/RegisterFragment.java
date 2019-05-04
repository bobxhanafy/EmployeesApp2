package com.example.employeesapp.fragments;


import android.content.ContentValues;
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
public class RegisterFragment extends Fragment {
    @BindView(R.id.email)
    EditText emailText;
    @BindView(R.id.pass)
    EditText pass1Text;
    @BindView(R.id.pass2)
    EditText pass2Text;
    @OnClick(R.id.reg)
    public void register(){
        String email = emailText.getText().toString();
        String pass = pass1Text.getText().toString();
        String pass2 = pass2Text.getText().toString();
        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass) && TextUtils.equals(pass, pass2)) {
            if (saveUserData(email, pass)) {
                Toast.makeText(getContext(), "User saved", Toast.LENGTH_SHORT).show();
                ((LoginScreen)getActivity()).go();
            }
        }
    }
    //go to Login fragment
    @OnClick(R.id.textView)
    public void goToLogin(){
        ((LoginScreen)getActivity()).goToLogin();
    }
    // Required empty public constructor
    public RegisterFragment() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    //save data
    private boolean saveUserData(String email, String pass) {
        DataHelper dbHelper = new DataHelper(getActivity());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Data.COL_USR_NAME, email);
        values.put(Data.COL_USR_PASS, pass);
        long row = db.insert(Data.TABLE_NAME1, null, values);
        return row > 0 ? true : false;

    }

}
