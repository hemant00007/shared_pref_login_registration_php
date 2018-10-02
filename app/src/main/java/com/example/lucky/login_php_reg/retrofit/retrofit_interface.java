package com.example.lucky.login_php_reg.retrofit;

import com.example.lucky.login_php_reg.model.Result_model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface retrofit_interface {

    @POST("signup.php")
    Call<Result_model> createUser(
            @Query("student_fname") String name,
            @Query("student_lname") String l_name,
            @Query("student_username") String u_name,
            @Query("student_email") String mail,
            @Query("student_password") String pass,
            @Query("student_mobile") String mob);



    @GET("login.php")
    Call<Result_model> login(
            @Query("student_username") String u_name,
            @Query("student_password") String pass);
}
