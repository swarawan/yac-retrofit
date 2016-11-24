package com.swarawan.yacretofit.presenter;

import android.content.Context;

import com.swarawan.yacretofit.base.BasePresenter;
import com.swarawan.yacretofit.model.request.LoginRequestModel;
import com.swarawan.yacretofit.model.response.LoginResponseModel;
import com.swarawan.yacretofit.network.ApiRestClient;
import com.swarawan.yacretofit.network.DataManager;
import com.swarawan.yacretofit.utility.Constant;
import com.swarawan.yacretofit.utility.PreferenceManager;
import com.swarawan.yacretofit.view.login.ILoginView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rioswarawan on 11/24/16.
 */

public class LoginPresenter extends BasePresenter<ILoginView> {
    private Context context;
    private DataManager dataManager;

    public LoginPresenter(Context context) {
        this.context = context;
        dataManager = new DataManager(context, new ApiRestClient(context).getService());
    }

    @Override
    public void attachView(ILoginView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void login(LoginRequestModel requestModel) {
        dataManager.login(requestModel).enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                LoginResponseModel responseModel = response.body();
                if (responseModel.isError()) {
                    getMvpView().onLoginFailed(responseModel.getMessage());
                } else {
                    PreferenceManager.putString(context, Constant.PREFERENCE_TOKEN, "Bearer " + responseModel.getToken());
                    getMvpView().onLoginSuccess();
                }
            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                getMvpView().onLoginFailed(t.getLocalizedMessage());
            }
        });
    }
}
