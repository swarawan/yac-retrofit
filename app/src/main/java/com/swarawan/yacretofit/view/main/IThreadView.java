package com.swarawan.yacretofit.view.main;

import com.swarawan.yacretofit.base.MvpView;
import com.swarawan.yacretofit.model.response.ThreadResponseModel;

import java.util.List;

/**
 * Created by rioswarawan on 11/24/16.
 */

public interface IThreadView extends MvpView {

    void onSuccessFetching(List<ThreadResponseModel.ThreadData> threads);

    void onFailedFetching(String message);
}
