package com.thirdcs.team_pe_cake.paper.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.thirdcs.team_pe_cake.paper.R;

import me.myatminsoe.mdetect.MDetect;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    TextView tvSignUp;
    Button btnLogIn, btnLogInFacebook;
    LinearLayout layoutForgotPassword;
    EditText etPhoneNumber, etPassword;

    TextView tvPhoneNumberValidation, tvPasswordValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MDetect.INSTANCE.init(this);
        initUI();

        tvSignUp.setOnClickListener(this);
        btnLogIn.setOnClickListener(this);
        layoutForgotPassword.setOnClickListener(this);
        btnLogInFacebook.setOnClickListener(this);
        etPassword.setOnFocusChangeListener(this);
        etPhoneNumber.setOnFocusChangeListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.tvSignUp:
                Intent intentSignUp = new Intent(this, SignupActivity.class);
                startActivity(intentSignUp);
                break;

            case R.id.btnLogIn:
                Intent intentBase = new Intent(this, MainDrawerActivity.class);
                startActivity(intentBase);
                finish();
                break;

            case R.id.layoutForgotPassword:
                Toast.makeText(this, "Do you forget your password?", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnLogInFacebook:

                if (etPhoneNumber.getText().toString().trim().length() == 0) {
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    etPhoneNumber.startAnimation(shake);
                    tvPhoneNumberValidation.setText("Enter your phone number!");
                    tvPhoneNumberValidation.setVisibility(View.VISIBLE);
                    tvPasswordValidation.setVisibility(View.INVISIBLE);
                    return;
                }

                if (etPassword.getText().toString().trim().length() == 0) {

                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    etPassword.startAnimation(shake);
                    tvPasswordValidation.setText("Enter your password!");
                    tvPasswordValidation.setVisibility(View.VISIBLE);
                    tvPhoneNumberValidation.setVisibility(View.INVISIBLE);
                    return;
                }

                if (etPhoneNumber.getText().toString().equals("199") && etPassword.getText().toString().equals("asd")) {
                    Toast.makeText(this, "Logged in", Toast.LENGTH_LONG).show();
                    tvPhoneNumberValidation.setVisibility(View.INVISIBLE);
                    tvPasswordValidation.setVisibility(View.INVISIBLE);
                } else if (!etPhoneNumber.getText().toString().equals("199")) {
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    etPhoneNumber.startAnimation(shake);
                    tvPhoneNumberValidation.setText("Invalid phone number!");
                    tvPhoneNumberValidation.setVisibility(View.VISIBLE);
                    tvPasswordValidation.setVisibility(View.INVISIBLE);
                } else if (!etPassword.getText().toString().equals("asd")) {
                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    etPassword.startAnimation(shake);
                    tvPasswordValidation.setText("Invalid password!");
                    tvPasswordValidation.setVisibility(View.VISIBLE);
                    tvPhoneNumberValidation.setVisibility(View.INVISIBLE);

                }


                break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {

        if (b) {
            tvPhoneNumberValidation.setVisibility(View.INVISIBLE);
            tvPasswordValidation.setVisibility(View.INVISIBLE);
        }

    }

    public void initUI() {

        tvSignUp = findViewById(R.id.tvSignUp);
        btnLogIn = findViewById(R.id.btnLogIn);
        layoutForgotPassword = findViewById(R.id.layoutForgotPassword);
        btnLogInFacebook = findViewById(R.id.btnLogInFacebook);
        etPhoneNumber = findViewById(R.id.etPhoneNumber);
        etPassword = findViewById(R.id.etPassword);
        tvPasswordValidation = findViewById(R.id.tvPasswordValidation);
        tvPhoneNumberValidation = findViewById(R.id.tvPhoneNumbeValidation);

    }
}
