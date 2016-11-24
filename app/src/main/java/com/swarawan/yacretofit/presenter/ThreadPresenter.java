package com.swarawan.yacretofit.presenter;

import android.content.Context;

import com.swarawan.yacretofit.base.BasePresenter;
import com.swarawan.yacretofit.model.request.LoginRequestModel;
import com.swarawan.yacretofit.model.response.LoginResponseModel;
import com.swarawan.yacretofit.model.response.ThreadResponseModel;
import com.swarawan.yacretofit.network.ApiRestClient;
import com.swarawan.yacretofit.network.DataManager;
import com.swarawan.yacretofit.utility.Constant;
import com.swarawan.yacretofit.utility.PreferenceManager;
import com.swarawan.yacretofit.view.login.ILoginView;
import com.swarawan.yacretofit.view.main.IThreadView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rioswarawan on 11/24/16.
 */

public class ThreadPresenter extends BasePresenter<IThreadView> {
    private Context context;
    private DataManager dataManager;

    public ThreadPresenter(Context context) {
        this.context = context;
        dataManager = new DataManager(context, new ApiRestClient(context).getService());
    }

    @Override
    public void attachView(IThreadView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void getThread() {
        dataManager.getThread().enqueue(new Callback<ThreadResponseModel>() {
            @Override
            public void onResponse(Call<ThreadResponseModel> call, Response<ThreadResponseModel> response) {
                ThreadResponseModel responseModel = response.body();
                if (responseModel.isError()) {
                    getMvpView().onFailedFetching(responseModel.getMessage());
                } else {
                    getMvpView().onSuccessFetching(responseModel.getData());
                }
            }

            @Override
            public void onFailure(Call<ThreadResponseModel> call, Throwable t) {
                getMvpView().onFailedFetching(t.getLocalizedMessage());
            }
        });
    }
}
