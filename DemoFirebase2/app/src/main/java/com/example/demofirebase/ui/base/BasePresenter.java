package com.example.demofirebase.ui.base;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mvpview;

    @Override
    public void onAttach(V mvpView) {
        mvpview = mvpView;
    }

    @Override
    public void onDetach() {

    }
}
