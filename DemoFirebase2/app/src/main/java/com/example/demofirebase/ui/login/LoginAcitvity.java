package com.example.demofirebase.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demofirebase.MainActivity;
import com.example.demofirebase.R;
import com.example.demofirebase.ui.base.BaseActivity;
import com.example.demofirebase.utils.ComponentUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginAcitvity extends BaseActivity implements LoginMvpView {

    @BindView(R.id.login_email)
    EditText loginEmail;
    @BindView(R.id.login_pass)
    EditText loginPass;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private LoginMvpPresenter loginMvpPresenter;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(LoginAcitvity.this, MainActivity.class));
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Dang nhap that bai", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginValidate() {
        Toast.makeText(this, "Email hoac mat khau khong hop le", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        hideLoading();
        progressDialog = ComponentUtil.showDialog(this);
    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing())
            progressDialog.cancel();
    }

    @Override
    public void showMessage(String message) {

    }

    @OnClick(R.id.btn_login)
    public void onClick(View view) {
        loginMvpPresenter.checkLogin(loginEmail.getText().toString(), loginPass.getText().toString());
    }

}
