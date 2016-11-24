package com.swarawan.yacretofit.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rioswarawan on 11/24/16.
 */

public class LoginResponseModel {

    @SerializedName("error")
    private boolean error;

    @SerializedName("token")
    private String token;

    @SerializedName("roles")
    private String roles;

    @SerializedName("message")
    private String message;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
