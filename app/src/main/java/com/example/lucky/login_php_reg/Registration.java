package com.example.lucky.login_php_reg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lucky.login_php_reg.model.Result_model;

import java.sql.BatchUpdateException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class Registration extends Fragment {


    public Registration() {
        // Required empty public constructor
    }

    EditText first_name,last_name,user_name,mobile,email,password;
    Button signup;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_registration, container, false);


        first_name=(EditText)view.findViewById(R.id.edit_first_name_id);
        last_name=(EditText)view.findViewById(R.id.edit_last_name_id);
        user_name =(EditText)view.findViewById(R.id.edit_user_name_id);
        mobile=(EditText)view.findViewById(R.id.edit_Mobile_id);
        email=(EditText)view.findViewById(R.id.edit_email_id);
        password=(EditText)view.findViewById(R.id.edit_Password_id);
        signup =(Button)view.findViewById(R.id.register_id);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performRegistration();

            }
        });

        return view;
    }

    public void performRegistration()
    {

        String name =first_name.getText().toString();
        String l_name=last_name.getText().toString();
        String u_name=user_name.getText().toString();
        String mob=mobile.getText().toString();
        String mail =email.getText().toString();
        String pass = password.getText().toString();
        Call<Result_model> call = MainActivity.interfce_obj.createUser(name,l_name,u_name,mob,mail,pass);

        call.enqueue(new Callback<Result_model>() {
            @Override
            public void onResponse(Call<Result_model> call, Response<Result_model> response) {
                if (response.body().getSuccess().equals("1"))
                {
                    MainActivity.config.display_toast("Registration successful.....");
                }
                else {
                    MainActivity.config.display_toast("Registration Failed...");
                }
            }

            @Override
            public void onFailure(Call<Result_model> call, Throwable t) {

            }
        });

        // reset all field to null;
        first_name.setText("");
        last_name.setText("");
    }



}
