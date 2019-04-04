package com.dan.automatetestdemo.services;

/**
 * Created by Dan Kim on 2019-04-03
 */
public class LoginService {


    public boolean login(String userName, String password) {

        return "dan".equals(userName) && "password".equals(password);
    }
}
