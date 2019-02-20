package com.example.demofirebase.ui.login;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.support.constraint.Constraints.TAG;

public class LoginPresenter implements LoginMvpPresenter {

    private LoginMvpView loginMvpView;
    private FirebaseAuth auth;

    @Override
    public void checkLogin(String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
            loginMvpView.loginValidate();
        else
        {
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                loginMvpView.loginSuccess();
                            } else {
                               loginMvpView.loginError();
                            }

                        }
                    });
        }
    }
}
