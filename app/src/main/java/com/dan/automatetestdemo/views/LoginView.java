package com.dan.automatetestdemo.views;

/**
 * Created by Dan Kim on 2019-04-03
 */
public interface LoginView {

    String getUserName();
    void showUserNameError(int resId);
    String getPassword();
    void showPasswordError(int resId);
    void showLoginError(int resId);
    void startLoginSuccessActivity();
}
