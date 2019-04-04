package com.dan.automatetestdemo.presenters;

import android.text.TextUtils;
import android.util.Log;

import com.dan.automatetestdemo.R;
import com.dan.automatetestdemo.services.LoginService;
import com.dan.automatetestdemo.views.LoginView;

/**
 * Created by Dan Kim on 2019-04-03
 */
public class LoginPresenter {
    private static final String TAG = "LoginPresenter";
    private LoginView loginView;
    private LoginService loginService;

    public LoginPresenter(LoginView loginView) {

        this.loginView = loginView;
        this.loginService = new LoginService();
    }

    public void onLoginClicked() {

        Log.d(TAG, "onLoginClicked: ");
        String userName = this.loginView.getUserName();
        if (userName.isEmpty()){
            this.loginView.showLoginError(R.string.username_error);
            return;
        }

        String password = this.loginView.getPassword();
        if (TextUtils.isEmpty(password)){
            this.loginView.showPasswordError(R.string.password_error);
            return;
        }

        boolean loginSuccess = this.loginService.login(userName,password);
        if (loginSuccess){
            this.loginView.startLoginSuccessActivity();

        }else{
            this.loginView.showLoginError(R.string.login_failed);
        }

    }
}
