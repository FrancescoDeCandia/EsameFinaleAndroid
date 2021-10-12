package com.example.esamefinaleandroid.attivita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.esamefinaleandroid.R;
import com.example.esamefinaleandroid.entitita.Account;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private static final String LOG_TAG = LoginActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    private ArrayList<Account> listaUtentiPresenti = new ArrayList<>();
    public static final String EXTRA_MESSAGE = "com.example.esamefinaleandroid.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEditTextUsername = findViewById(R.id.editTextUsername);
        mEditTextPassword = findViewById(R.id.editTextPassword);

    }

    public void launchLoginActivity(View view) {
        Log.d(LOG_TAG, "Button LOGIN clicked!");
        for (Account account: listaUtentiPresenti)
            if (mEditTextUsername.getText().toString().equals(account.getUsername())) {
                if (mEditTextPassword.getText().toString().equals(account.getPassword())) {
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.putExtra(EXTRA_MESSAGE, account);
                    //TODO passare oggetto account verso Main Activity
                    startActivity(intent);
                }
            } else Log.d(LOG_TAG, "Utente non presente!");
    }

    public void launchRegisterActivity(View view) {
        Log.d(LOG_TAG, "Button REGISTER clicked!");
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                Account reply = data.getParcelableExtra(RegisterActivity.EXTRA_REPLY);
                listaUtentiPresenti.add(reply);
            }
        }
    }

}