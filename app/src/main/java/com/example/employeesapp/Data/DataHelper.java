package com.example.employeesapp.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.employeesapp.Model.EmpModel;

import java.util.ArrayList;
import java.util.List;

import static com.example.employeesapp.Data.Data.TABLE_NAME2;

public class DataHelper extends SQLiteOpenHelper {

    public DataHelper( Context context){super(context, Data.DB_NAME, null, Data.DB_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //create users table
        String sql = "create table "+Data.TABLE_NAME1+" ( "+Data.COL_USR_ID+" integer primary key autoincrement, "+
                Data.COL_USR_NAME+" text, "+Data.COL_USR_PASS+" text )";
        sqLiteDatabase.execSQL(sql);

        //create employee table
        String sql1 = "create table "+ TABLE_NAME2+" ( "+Data.COL_EM_ID+" integer primary key autoincrement, "+
                Data.COL_EM_NAME+" text, "+Data.COL_EM_ADDRESS+" text, "+Data.COL_EM_ROLE+" text, "+Data.COL_EM_salary+" text, "+Data.COL_EM_DATE+" text, "+
                Data.COL_EM_GENDER+" text ) ";
        sqLiteDatabase.execSQL(sql1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql_us = "drop table "+Data.TABLE_NAME1;
        db.execSQL(sql_us);
        String sql_em = "drop table "+ TABLE_NAME2;
        db.execSQL(sql_em);
        onCreate(db);
    }

    //Save employees
    public boolean saveEmployees(String name, String role, String address, String date, String gender,String salary) {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Data.COL_EM_NAME,name);
        values.put(Data.COL_EM_ROLE,role);
        values.put(Data.COL_EM_ADDRESS,address);
        values.put(Data.COL_EM_DATE,date);
        values.put(Data.COL_EM_GENDER,gender);
        values.put(Data.COL_EM_salary,salary);
        long row = db.insert(Data.TABLE_NAME2, null, values);
        return row>0?true:false;
    }

    //View employees
    public List<EmpModel> getData(){
        List<EmpModel> data=new ArrayList<>();
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_NAME2+" ;",null);
        StringBuffer stringBuffer = new StringBuffer();
        EmpModel empModel = null;

        while (cursor.moveToNext()) {
            empModel= new EmpModel();
            String name = cursor.getString(cursor.getColumnIndexOrThrow(Data.COL_EM_NAME));
            String role = cursor.getString(cursor.getColumnIndexOrThrow(Data.COL_EM_ROLE));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(Data.COL_EM_ADDRESS));
            String gender = cursor.getString(cursor.getColumnIndexOrThrow(Data.COL_EM_GENDER));
            String salary = cursor.getString(cursor.getColumnIndexOrThrow(Data.COL_EM_salary));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(Data.COL_EM_DATE));
            empModel.setName(name);
            empModel.setRole(role);
            empModel.setAddress(address);
            empModel.setGender(gender);
            empModel.setSalary(salary);
            empModel.setBirthDate(date);
            stringBuffer.append(empModel);
            data.add(empModel);
        }
        for (EmpModel empModel1:data) {
            empModel1.getName();
            empModel1.getRole();
            empModel.getAddress();
            empModel.getSalary();
            empModel.getGender();
            empModel.getBirthDate();
        }
        return data;
    }
}
