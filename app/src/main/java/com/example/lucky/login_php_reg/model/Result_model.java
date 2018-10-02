package com.example.lucky.login_php_reg.model;

import com.google.gson.annotations.SerializedName;

public class Result_model {

    @SerializedName("Success")
    private String Success;
    @SerializedName("message")
    private String message;

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
