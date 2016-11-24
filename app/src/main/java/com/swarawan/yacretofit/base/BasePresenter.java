package com.swarawan.yacretofit.base;

/**
 * Created by rioswarawan on 9/1/16.
 */
public class BasePresenter<T extends MvpView> implements Presenter<T> {

  private T mvpView;

  @Override
  public void attachView(T mvpView) {
    this.mvpView = mvpView;
  }

  @Override
  public void detachView() {
    mvpView = null;
  }

  public boolean isViewAttached() {
    return mvpView != null;
  }

  public T getMvpView() {
    return mvpView;
  }

  public void checkViewAttached() {
    if (!isViewAttached()) throw new MvpViewNotAttachedException();
  }

  public static class MvpViewNotAttachedException extends RuntimeException {
    public MvpViewNotAttachedException() {
      super(
          "Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter");
    }
  }
}
