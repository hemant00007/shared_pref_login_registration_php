package com.example.lucky.login_php_reg;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Welcome_frag extends Fragment {

    public interface LogoutListner{
        public void logout_perform();
    }

    TextView name;
    Button logout;

    LogoutListner logoutListner;


    public Welcome_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_welcome_frag, container, false);

        name =(TextView)view.findViewById(R.id.name);
        name.setText(" welcome"+ MainActivity.config.readName());
        logout=(Button)view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoutListner.logout_perform();
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        logoutListner =(LogoutListner) activity;
    }
}
