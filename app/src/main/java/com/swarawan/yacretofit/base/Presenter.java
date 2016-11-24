package com.swarawan.yacretofit.base;

/**
 * Created by rioswarawan on 9/1/16.
 */
public interface Presenter<V extends MvpView> {

  void attachView(V mvpView);

  void detachView();
}
