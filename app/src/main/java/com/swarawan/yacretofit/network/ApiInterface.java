package com.swarawan.yacretofit.network;

import com.swarawan.yacretofit.model.request.LoginRequestModel;
import com.swarawan.yacretofit.model.response.LoginResponseModel;
import com.swarawan.yacretofit.model.response.ThreadResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by Rio Swarawan on 5/20/2016.
 */
public interface ApiInterface {

    @POST("api/login")
    Call<LoginResponseModel> login(@Body LoginRequestModel body);

    @GET("api/threads")
    Call<ThreadResponseModel> getThread(@Header("X-Authorization") String token);
}
