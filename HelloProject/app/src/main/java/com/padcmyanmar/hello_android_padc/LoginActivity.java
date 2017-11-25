package com.padcmyanmar.hello_android_padc;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Login Activity.
 *  - username/password input
 *  - login button click
 */

public class LoginActivity extends AppCompatActivity {

    private static final String CORRECT_EMAIL    = "abc@gmail.com";
    private static final String CORRECT_PASSWORD = "Abcdefg";

    private Button   btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgotPassword;
    private TextView btnRegister;
    private Snackbar btnLoginSnackBar;
    private Snackbar btnForgotPasswordSnackBar;
    private Snackbar btnRegisterSnackBar;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin          = findViewById(R.id.btn_login);
        etEmailOrPhone    = findViewById(R.id.et_email_or_phone);
        etPassword        = findViewById(R.id.et_password);
        btnForgotPassword = findViewById(R.id.btn_forgot_password);
        btnRegister       = findViewById(R.id.btn_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.d("Login", "Login button click event.");

                String strEmailOrPhone = etEmailOrPhone.getText().toString().trim();
                String strPassword = etPassword.getText().toString().trim();

                if (TextUtils.isEmpty(strEmailOrPhone)) {
                    etEmailOrPhone.requestFocus();
                    etEmailOrPhone.setError("Email Or Phone can not be empty.");
                    return;
                }

                if (TextUtils.isEmpty(strPassword)) {
                    etPassword.requestFocus();
                    etPassword.setError("Password can not be empty;");
                    return;
                }

                if (TextUtils.equals(strEmailOrPhone, CORRECT_EMAIL) && TextUtils.equals(strPassword, CORRECT_PASSWORD)) {
                    if (btnLoginSnackBar != null ) btnLoginSnackBar.dismiss();
                    if (btnForgotPasswordSnackBar != null) btnForgotPasswordSnackBar.dismiss();
                    if (btnRegisterSnackBar != null) btnRegisterSnackBar.dismiss();

                    // Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();

                    Log.d("Login", "Login Successful.");
                    Intent intentHelloAndroidActivity = HelloAndroidActivity.Companion.newIntent(getApplicationContext());
                    startActivity(intentHelloAndroidActivity);
                }
                else {
                    etPassword.setText("");
                    etEmailOrPhone.requestFocus();

                    btnLoginSnackBar = Snackbar.make(view, "Incorrect Email or Password. Please try again...", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Action", null);
                    btnLoginSnackBar.getView().setBackgroundColor(Color.RED);
                    btnLoginSnackBar.show();

                    return;
                }


                /* // comment snack bar.
                    Snackbar btnLoginSnackBar = Snackbar.make(view, "Waiting to login....", Snackbar.LENGTH_INDEFINITE)
                                                        .setAction("Action", null);
                    btnLoginSnackBar.getView().setBackgroundColor(Color.parseColor("#009688"));
                    btnLoginSnackBar.show();
                 */
            }

        });

        btnForgotPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.d("Login", "Forgot password link click event.");

                btnForgotPasswordSnackBar = Snackbar.make(view, "\"Forgot Password\" is coming soon.", Snackbar.LENGTH_INDEFINITE)
                        .setAction("Action", null);
                btnForgotPasswordSnackBar.getView().setBackgroundColor(Color.parseColor("#009688"));
                btnForgotPasswordSnackBar.show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Log.d("Login", "Register link click event.");

                Intent intentRegisterActivity = RegisterActivity.newIntent(getApplicationContext());
                startActivity(intentRegisterActivity);
            }
        });
    }

}
