package com.example.demofirebase.ui.register;

import com.example.demofirebase.ui.base.MvpPresenter;

public interface RegisterMvpPresenter<V extends RegisterMvpView> extends MvpPresenter<V> {

    void onRegister(String email, String password);

}
