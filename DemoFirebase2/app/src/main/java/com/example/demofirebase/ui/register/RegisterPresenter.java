package com.example.demofirebase.ui.register;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.example.demofirebase.ui.base.BasePresenter;
import com.example.demofirebase.ui.base.MvpView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static android.content.ContentValues.TAG;

public class RegisterPresenter <V extends RegisterMvpView> extends BasePresenter implements RegisterMvpPresenter {


    private RegisterMvpView mvpView;
    private FirebaseAuth auth;

    public RegisterPresenter(FirebaseAuth auth) {
        this.auth = auth;
    }

    @Override
    public void onRegister(String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
            mvpView.onValidate();
        else
        {
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                mvpView.onSuccess();

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                mvpView.onError();
                            }

                            // ...
                        }
                    });
        }
    }

}
