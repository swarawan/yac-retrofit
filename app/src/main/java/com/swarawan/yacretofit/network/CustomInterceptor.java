package com.swarawan.yacretofit.network;

import android.content.Context;

import com.swarawan.yacretofit.utility.Constant;
import com.swarawan.yacretofit.utility.PreferenceManager;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rioswarawan on 11/24/16.
 */

public class CustomInterceptor implements Interceptor {
    private Context context;

    public CustomInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        requestBuilder.header("Accept", "application/json");

        String token = PreferenceManager.getString(context, Constant.PREFERENCE_TOKEN, "");
        if (!token.isEmpty())
            requestBuilder.header("X-Authorization", "Bearer " + token).build();

        request = requestBuilder.build();
        return chain.proceed(request);
    }
}
