package com.swarawan.yacretofit.model.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by rioswarawan on 11/24/16.
 */

public class LoginRequestModel {

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;

    @SerializedName("pushbots_token")
    private String pushbotsToken;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPushbotsToken() {
        return pushbotsToken;
    }

    public void setPushbotsToken(String pushbotsToken) {
        this.pushbotsToken = pushbotsToken;
    }
}
