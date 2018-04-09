package com.thirdcs.team_pe_cake.paper.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.thirdcs.team_pe_cake.paper.R;

/**
 * Created by minthihaaung on 4/9/18.
 */

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout layoutAlreadyHaveAccount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        layoutAlreadyHaveAccount = findViewById(R.id.layoutAlreadyHaveAccount);
        layoutAlreadyHaveAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.layoutAlreadyHaveAccount:
                startActivity(new Intent(this, LoginActivity.class));
                break;

        }
    }
}
