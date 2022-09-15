package com.nk.mailandpasswordvalidationtemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText emailEt, passwordEt;
    private CheckBox numCharCb, numCb, upperCb, symbolsCb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setReferences();

        inputPasswordChange();
    }

    private void setReferences(){
        emailEt = findViewById(R.id.email_et);
        passwordEt = findViewById(R.id.password_et);
        numCharCb = findViewById(R.id.num_char_cb);
        numCb = findViewById(R.id.num_cb);
        upperCb = findViewById(R.id.upper_cb);
        symbolsCb = findViewById(R.id.symbols_cb);
    }

    private void inputPasswordChange(){
        passwordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                passwordValidation();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        emailEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                validationEmailAddress();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void passwordValidation() {
        String password = passwordEt.getText().toString();

        //number characters
        if (password.length() < 8){
            numCharCb.setTextColor(getColor(R.color.red));
            numCharCb.setChecked(false);
        }else{
            numCharCb.setTextColor(getColor(R.color.green));
            numCharCb.setChecked(true);
        }

        //if have numbers in password
        if (password.matches("(.*[0-9].*)")){
            numCb.setTextColor(getColor(R.color.green));
            numCb.setChecked(true);
        }else{
            numCb.setTextColor(getColor(R.color.red));
            numCb.setChecked(false);
        }

        //if have Uppercase
        if (password.matches("(.*[A-Z].*)")){
            upperCb.setTextColor(getColor(R.color.green));
            upperCb.setChecked(true);
        }else{
            upperCb.setTextColor(getColor(R.color.red));
            upperCb.setChecked(false);
        }

        //if have symbols
        if(password.matches("^(?=.*[_.()$&@]).*$")){
            symbolsCb.setTextColor(getColor(R.color.green));
            symbolsCb.setChecked(true);
        }else{
            symbolsCb.setTextColor(getColor(R.color.red));
            symbolsCb.setChecked(false);
        }
    }

    private void validationEmailAddress(){

        String email = emailEt.getText().toString();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (email.matches(emailPattern) && email.length() > 5){
            emailEt.setBackground(getDrawable(R.drawable.success_input));
        }else{
            emailEt.setBackground(getDrawable(R.drawable.error_input));
        }
    }
}