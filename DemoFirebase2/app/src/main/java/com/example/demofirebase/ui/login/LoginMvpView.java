package com.example.demofirebase.ui.login;

import com.example.demofirebase.ui.base.MvpView;

public interface LoginMvpView extends MvpView {

    void loginSuccess();

    void loginError();

    void loginValidate();
}
