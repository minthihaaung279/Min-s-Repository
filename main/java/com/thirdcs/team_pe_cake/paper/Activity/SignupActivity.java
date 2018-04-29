package com.thirdcs.team_pe_cake.paper.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.thirdcs.team_pe_cake.paper.R;

/**
 * Created by minthihaaung on 4/9/18.
 */

public class SignupActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    LinearLayout layoutAlreadyHaveAccount;

    EditText etUsername, etSignUpPhonenumber, etSignUpPassword, etSignUpRePassword;

    Button btnSignUp;

    TextView tvNameValidation, tvPhoneValidation, tvSignUpPassValidation, tvSignUpRePassValidation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        layoutAlreadyHaveAccount = findViewById(R.id.layoutAlreadyHaveAccount);
        layoutAlreadyHaveAccount.setOnClickListener(this);

        etUsername = findViewById(R.id.etUsername);
        etSignUpPhonenumber = findViewById(R.id.etSignUpPnoneNuber);
        etSignUpPassword = findViewById(R.id.etSignUpPassword);
        etSignUpRePassword = findViewById(R.id.etSignUpRePassword);

        etUsername.setOnFocusChangeListener(this);
        etSignUpRePassword.setOnFocusChangeListener(this);
        etSignUpPassword.setOnFocusChangeListener(this);
        etSignUpPhonenumber.setOnFocusChangeListener(this);

        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);

        tvNameValidation = findViewById(R.id.tvNameValidation);
        tvPhoneValidation = findViewById(R.id.tvPhoneValidation);
        tvSignUpPassValidation = findViewById(R.id.tvSignUpPassValidition);
        tvSignUpRePassValidation = findViewById(R.id.tvRePasswordValidation);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.layoutAlreadyHaveAccount:
                startActivity(new Intent(this, LoginActivity.class));
                break;

            case R.id.btnSignUp:

                if (etSignUpPassword.getText().toString().equals(etSignUpRePassword.getText().toString()))
                    tvSignUpRePassValidation.setVisibility(View.INVISIBLE);

                if (isNotHasValue(etUsername)) {
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    etUsername.startAnimation(shake);
                    tvNameValidation.setText("Enter your name!");
                    tvNameValidation.setVisibility(View.VISIBLE);
                } else tvNameValidation.setVisibility(View.INVISIBLE);

                if (isNotHasValue(etSignUpPhonenumber)) {
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    etSignUpPhonenumber.startAnimation(shake);
                    tvPhoneValidation.setText("Enter your phone number!");
                    tvPhoneValidation.setVisibility(View.VISIBLE);
                } else tvPhoneValidation.setVisibility(View.INVISIBLE);

                if (isNotHasValue(etSignUpPassword)) {
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    etSignUpPassword.startAnimation(shake);
                    tvSignUpPassValidation.setText("Enter your password!");
                    tvSignUpPassValidation.setVisibility(View.VISIBLE);
                } else tvSignUpRePassValidation.setVisibility(View.INVISIBLE);

                if (isNotHasValue(etSignUpRePassword)) {
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    etSignUpRePassword.startAnimation(shake);
                    tvSignUpRePassValidation.setText("Renter your password!");
                    tvSignUpRePassValidation.setVisibility(View.VISIBLE);
                } else if (!etSignUpRePassword.getText().toString().equals(etSignUpPassword.getText().toString())) {
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    etSignUpRePassword.startAnimation(shake);
                    tvSignUpRePassValidation.setText("Password don't match!");
                    tvSignUpRePassValidation.setVisibility(View.VISIBLE);
                }

                break;

        }
    }

    public boolean isNotHasValue(View v) {

        if (((EditText) v).getText().toString().trim().length() == 0)
            return true;
        else
            return false;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            tvNameValidation.setVisibility(View.INVISIBLE);
            tvPhoneValidation.setVisibility(View.INVISIBLE);
            tvSignUpPassValidation.setVisibility(View.INVISIBLE);
            tvSignUpRePassValidation.setVisibility(View.INVISIBLE);
        }
    }
}
