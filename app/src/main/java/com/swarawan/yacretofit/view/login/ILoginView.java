package com.swarawan.yacretofit.view.login;

import com.swarawan.yacretofit.base.MvpView;

/**
 * Created by rioswarawan on 11/24/16.
 */

public interface ILoginView extends MvpView {

    void onLoginSuccess();

    void onLoginFailed(String message);
}
