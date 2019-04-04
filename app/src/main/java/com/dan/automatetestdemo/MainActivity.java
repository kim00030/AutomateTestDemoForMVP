package com.dan.automatetestdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dan.automatetestdemo.presenters.LoginPresenter;
import com.dan.automatetestdemo.services.LoginService;
import com.dan.automatetestdemo.views.LoginView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements LoginView {
    private static final String TAG = "MainActivity";
    private EditText etUserName, etPassword;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);
        //Presenter
        loginPresenter = new LoginPresenter(this);
    }

    public void onLoginClicked(View view) {

        loginPresenter.onLoginClicked();
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString();
    }

    @Override
    public void showUserNameError(int resId) {

        etUserName.setError(getString(resId));
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void showPasswordError(int resId) {
        etPassword.setError(getString(resId));
    }

    @Override
    public void showLoginError(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startLoginSuccessActivity() {

        Intent intent = new Intent(this, LoginSuccessActivity.class);
        startActivity(intent);
    }
}
