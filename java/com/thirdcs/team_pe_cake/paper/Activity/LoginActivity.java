package com.thirdcs.team_pe_cake.paper.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.thirdcs.team_pe_cake.paper.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvSignUp;
    Button btnLogIn;
    LinearLayout layoutForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvSignUp = findViewById(R.id.tvSignUp);
        tvSignUp.setOnClickListener(this);

        btnLogIn = findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(this);

        layoutForgotPassword = findViewById(R.id.layoutForgotPassword);
        layoutForgotPassword.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.tvSignUp:
                Intent intentSignUp = new Intent(this, SignupActivity.class);
                startActivity(intentSignUp);
                break;

            case R.id.btnLogIn:
                Intent intentBase = new Intent(this, BaseActivity.class);
                startActivity(intentBase);
                break;

            case R.id.layoutForgotPassword:
                Toast.makeText(this, "Do you forget your password?", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
