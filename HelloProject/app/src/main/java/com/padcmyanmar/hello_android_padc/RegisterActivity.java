package com.padcmyanmar.hello_android_padc;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getName();

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;
    }

    private EditText etUsername;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private RadioGroup radioGrpGender;
    private RadioButton radioBtnGender;
    private EditText etAddress;
    private CheckBox cbMyHomeAddress;
    private Button btnRegister;
    private TextView btnToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.et_username);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        etConfirmPassword = findViewById(R.id.et_confirm_password);
        radioGrpGender = findViewById(R.id.radiogrp_gender);
        etAddress = findViewById(R.id.et_address);
        cbMyHomeAddress = findViewById(R.id.cb_myhome_address);
        btnRegister = findViewById(R.id.btn_register);
        btnToLogin = findViewById(R.id.btn_to_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(TAG, "Register Button Click.");

                String strUsername = etUsername.getText().toString().trim();
                if (TextUtils.isEmpty(strUsername)) {
                    etUsername.requestFocus();
                    etUsername.setError("Username is required.");
                    return;
                }

                String strPhone = etPhone.getText().toString().trim();
                if (TextUtils.isEmpty(strPhone)) {
                    etPhone.requestFocus();
                    etPhone.setError("Phone Number is required.");
                    return;
                }

                String strEmail = etEmail.getText().toString().trim();
                if (TextUtils.isEmpty(strEmail)) {
                    etEmail.requestFocus();
                    etEmail.setError("Email is required.");
                    return;
                }

                String strPassword = etPassword.getText().toString().trim();
                String strConfirmPassword = etConfirmPassword.getText().toString().trim();
                if (TextUtils.isEmpty(strPassword)) {
                    etPassword.requestFocus();
                    etPassword.setError("Password is required.");
                    return;
                }
                if (TextUtils.isEmpty(strConfirmPassword)) {
                    etConfirmPassword.requestFocus();
                    etConfirmPassword.setError("Confirm password is required.");
                    return;
                }
                if (!TextUtils.equals(strPassword, strConfirmPassword)) {
                    etPassword.setText("");
                    etConfirmPassword.setText("");
                    etPassword.requestFocus();
                    etPassword.setError("Password and Confirm Password does not match.");
                    return;
                }

                String strAddress = etAddress.getText().toString().trim();
                if (TextUtils.isEmpty(strAddress)) {
                    etAddress.requestFocus();
                    etAddress.setError("Address is required.");
                    return;
                }

                int selectedRadioIndex = radioGrpGender.getCheckedRadioButtonId();
                radioBtnGender = findViewById(selectedRadioIndex);
                Log.d(TAG, "Radio Button <" + radioBtnGender.getText() + "> is checked.");

                boolean isMyHomeAddress = cbMyHomeAddress.isChecked();
                Log.d(TAG, "Checkbox is checked ? " + isMyHomeAddress);

                // successful
                AlertDialog.Builder dialog= new AlertDialog.Builder(RegisterActivity.this);
                dialog.setTitle("Message");
                dialog.setMessage("Registration is successful.");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        goToLoginScreen();
                    }
                });
                dialog.show();

            }
        });

        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginScreen();
            }
        });

    }

    private void goToLoginScreen() {
//        Intent intentLoginActivity = LoginActivity.newIntent(getApplicationContext());
        Intent intentLoginActivity = new Intent(this, LoginActivity.class);
        startActivity(intentLoginActivity);
    }
}
