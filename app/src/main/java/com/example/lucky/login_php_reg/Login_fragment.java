package com.example.lucky.login_php_reg;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lucky.login_php_reg.model.Result_model;

import javax.xml.transform.Result;

import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login_fragment extends Fragment {

    TextView textView;
    EditText userid,pass;
    Button login;
    loginformAcitvityListner listner;

    public interface loginformAcitvityListner{

        public void perform_register();
        public void perform_Login(String name);



    }


    public Login_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_fragment, container, false);
        textView = view.findViewById(R.id.signup_id);
        userid =(EditText)view.findViewById(R.id.userid);
        pass =(EditText)view.findViewById(R.id.pass);
        login =(Button)view.findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my_login();

            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listner.perform_register();

            }
        });

        return view;
    }

    private void my_login()
    {
        String username = userid.getText().toString();
        String password = pass.getText().toString();
        retrofit2.Call<Result_model> call = MainActivity.interfce_obj.login(username,password);
        call.enqueue(new Callback<Result_model>() {
            @Override
            public void onResponse(retrofit2.Call<Result_model> call, Response<Result_model> response) {
                if (response.body().getSuccess().equals("1")){

                    MainActivity.config.writeLoginStatus(true);
                    listner.perform_Login(response.body().getMessage());
                }
                else if (response.body().getSuccess().equals("0"))
                {
                    MainActivity.config.display_toast("LOgin Failed...");
                }
            }

            @Override
            public void onFailure(retrofit2.Call<Result_model> call, Throwable t) {

            }
        });

        // black the edittext
        userid.setText("");
        pass.setText("");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity =  (Activity) context;
        listner = (loginformAcitvityListner) activity;
    }
}
