package com.example.demofirebase.ui.register;

import com.example.demofirebase.ui.base.MvpView;

public interface RegisterMvpView  extends MvpView {

    void onValidate();

    void onSuccess();

    void onError();
}
