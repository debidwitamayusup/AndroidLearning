package com.example.debi.androidlearning;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by debi on 19/12/17.
 */

public class LoginActivity extends BaseActivity {

    private static final String UNAME = "admin";
    private static final String PWD = "password";

    @BindView(R.id.etUsername)
    EditText username;
    @BindView(R.id.etPassword)
    EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);
        ButterKnife.bind(LoginActivity.this);

        //Button btnLogin = (Button) findViewById(R.id.btnLogin);
        // username = (EditText) findViewById(R.id.etUsername);


//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String u = username.getText().toString();
//                Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                i.putExtra("username", u);
//                startActivity(i);
//                finish();
//            }
//        });

    }

    @OnClick(R.id.btnLogin)
    void goToLogin() {


        String u = username.getText().toString();
        String p = password.getText().toString();
        Call<Response> call = getApi().doLogin(u, p);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {

                    if (response.body().getStatus().equals("200")) {
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        i.putExtra("username", response.body().getFullname());
                        startActivity(i);
                        finish();
                    } else if (response.body().getStatus().equals("500")) {
                        Toast.makeText(LoginActivity.this,
                                response.body().getMessage(),
                                Toast.LENGTH_LONG)
                                .show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,
                            "Connection refused",
                            Toast.LENGTH_LONG)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
            }
        });

//        if (validatePwd()) {
//            String u = username.getText().toString();
//            Intent i = new Intent(LoginActivity.this, MainActivity.class);
//            i.putExtra("username", u);
//            startActivity(i);
//            finish();
//        }else{
//            Toast.makeText(this, "Username/Password is invalid", Toast.LENGTH_LONG).show();
//        }
//    }
    }
    private boolean validatePwd(){
        String u = username.getText().toString();
        String p = password.getText().toString();

        if(u.equals(UNAME) && p.equals(PWD)){
            return  true;
        }else{
            return false;
        }
    }
}
