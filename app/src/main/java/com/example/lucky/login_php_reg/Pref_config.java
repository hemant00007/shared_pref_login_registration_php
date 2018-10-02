package com.example.lucky.login_php_reg;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Pref_config {

    private SharedPreferences preferences;
    private Context context;


   public Pref_config(Context context){
        this.context=context;
        preferences = context.getSharedPreferences(context.getString(R.string.pref_file),context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status){
       SharedPreferences.Editor editor = preferences.edit();
       editor.putBoolean(context.getString(R.string.pref_login_status),status);
       editor.commit();
    }

    public boolean readLoginStatus(){
       return preferences.getBoolean(context.getString(R.string.pref_login_status),false);
    }

    public void writeName(String name)
    {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(context.getString(R.string.pref_user_name),name);
        editor.commit();
    }
    public String readName()
    {
        return preferences.getString(context.getString(R.string.pref_user_name),"user");

    }

    public void display_toast(String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }


}
