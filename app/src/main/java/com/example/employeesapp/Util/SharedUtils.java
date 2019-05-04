package com.example.employeesapp.Util;

import android.content.Context;

public class SharedUtils {
    public static void saveUserSession(Context context, boolean b){
        context.getSharedPreferences("EmployeesApp",Context.MODE_PRIVATE).edit().putBoolean("login",b).commit();
    }

    public static boolean getUserSession(Context context){
        return context.getSharedPreferences("EmployeesApp",Context.MODE_PRIVATE).getBoolean("login",false);
    }
}
