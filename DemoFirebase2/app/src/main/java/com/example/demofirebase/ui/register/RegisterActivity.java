package com.example.demofirebase.ui.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demofirebase.R;
import com.example.demofirebase.ui.base.BaseActivity;
import com.example.demofirebase.ui.login.LoginAcitvity;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegisterActivity extends BaseActivity implements RegisterMvpView {

    @BindView(R.id.edt_email)
    EditText edtEmail;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_register)
    Button btnRegister;

    private Unbinder mUnbinder;

    private RegisterMvpPresenter registerPresenter;

    private FirebaseAuth auth;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        setUnbinder(ButterKnife.bind(this));
        registerPresenter.onAttach(RegisterActivity.this);

        auth = FirebaseAuth.getInstance();
    }


    @OnClick(R.id.btn_register)
    void onRegister(View v)
    {
        registerPresenter.onRegister(edtEmail.getText().toString(), edtPassword.getText().toString());
    }

    @Override
    public void onValidate() {
        Toast.makeText(this, "Email hoac password khong hop le", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(RegisterActivity.this, LoginAcitvity.class));
    }


    @Override
    public void onError() {
        Toast.makeText(this, "Dang ky that bai", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onDestroy() {
        registerPresenter.onDetach();
        super.onDestroy();
    }

    public void setUnbinder(Unbinder unbinder)
    {
        mUnbinder = unbinder;
    }

}
