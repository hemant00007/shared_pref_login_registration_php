package com.example.lucky.login_php_reg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.lucky.login_php_reg.retrofit.retrofit_interface;
import com.example.lucky.login_php_reg.retrofit.retrofit_client;

public class MainActivity extends AppCompatActivity implements Login_fragment.loginformAcitvityListner,Welcome_frag.LogoutListner{

    public static Pref_config config;
    public static retrofit_interface  interfce_obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        config = new Pref_config(this);
        interfce_obj =retrofit_client.getRetrofit().create(retrofit_interface.class);
        if(findViewById(R.id.fragment_container)!=null){

            if (savedInstanceState!=null){
                return;
            }

            if (config.readLoginStatus())
            {
                // user alreday logged in , show Welcome page.
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new Welcome_frag()).commit();

            }
            else
            {

                //User not login. show login page
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new Login_fragment()).commit();
            }
        }
    }

    @Override
    public void perform_register() {

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Registration()).addToBackStack(null).commit();

    }

    @Override
    public void perform_Login(String name) {

        config.writeName(name);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Welcome_frag()).commit();

    }

    @Override
    public void logout_perform() {

        config.writeLoginStatus(false);
        config.writeName("user");

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new Login_fragment()).commit();

    }
}
