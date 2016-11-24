package com.swarawan.yacretofit.network;

import android.content.Context;

import com.swarawan.yacretofit.model.request.LoginRequestModel;
import com.swarawan.yacretofit.model.response.LoginResponseModel;
import com.swarawan.yacretofit.model.response.ThreadResponseModel;
import com.swarawan.yacretofit.utility.Constant;
import com.swarawan.yacretofit.utility.PreferenceManager;

import retrofit2.Call;

/**
 * Created by rioswarawan on 8/3/16.
 */
public class DataManager {

    private ApiInterface apiInterface;
    private Context context;

    public DataManager(Context context, ApiInterface apiInterface) {
        this.context = context;
        this.apiInterface = apiInterface;
    }

    public Call<LoginResponseModel> login(LoginRequestModel request) {
        return apiInterface.login(request);
    }

    public Call<ThreadResponseModel> getThread() {
        String token = PreferenceManager.getString(context, Constant.PREFERENCE_TOKEN, "");
        return apiInterface.getThread(token);
    }
}
