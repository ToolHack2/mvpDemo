package com.example.demofirebase.ui.base;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.demofirebase.utils.ComponentUtil;

public abstract class BaseActivity extends AppCompatActivity implements MvpView{

    private Context applicationContext;
    private ProgressDialog progressdialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public Context getApplicationContext()
    {
        return applicationContext;
    }

    @Override
    public void showLoading() {
        hideLoading();
        progressdialog = ComponentUtil.showDialog(this);
    }

    @Override
    public void hideLoading() {
        if (progressdialog != null && progressdialog.isShowing())
            progressdialog.cancel();
    }

    @Override
    public void showMessage(String message) {

    }
}
