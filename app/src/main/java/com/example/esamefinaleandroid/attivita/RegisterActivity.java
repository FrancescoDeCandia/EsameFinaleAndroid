package com.example.esamefinaleandroid.attivita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.esamefinaleandroid.R;
import com.example.esamefinaleandroid.entitita.Account;
import com.example.esamefinaleandroid.entitita.Citta;
import com.example.esamefinaleandroid.entitita.Persona;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private EditText mTextViewNome;
    private EditText mTextViewCognome;
    private EditText mTextViewEta;
    private EditText mTextViewTelefono;
    private RadioGroup mRadioButtonSesso;
    private EditText mTextViewCitta;
    private EditText mTextViewProvincia;
    private EditText mTextViewUsername;
    private EditText mTextViewPassword;
    private static final String LOG_TAG = RegisterActivity.class.getSimpleName();
    private static ArrayList<Account> accountList = new ArrayList<>();

    public static final String EXTRA_REPLY = "com.example.esamefinaleandroid.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mTextViewNome = findViewById(R.id.registerNome);
        mTextViewCognome = findViewById(R.id.registerCognome);
        mTextViewEta = findViewById(R.id.registerEta);
        mTextViewTelefono = findViewById(R.id.registerTelefono);
        mRadioButtonSesso = findViewById(R.id.registerSesso);
        mTextViewCitta = findViewById(R.id.registerCitta);
        mTextViewProvincia = findViewById(R.id.registerProvincia);
        mTextViewUsername = findViewById(R.id.registerUsername);
        mTextViewPassword = findViewById(R.id.registerPassword);

    }

    public void creaAccount(View view) {

        final String value = ((RadioButton)findViewById(mRadioButtonSesso.getCheckedRadioButtonId())).getText().toString();

        Citta citta1 = new Citta(mTextViewCitta.getText().toString(),
                                mTextViewProvincia.getText().toString());

        Persona persona1 = new Persona(mTextViewNome.getText().toString(),
                                        mTextViewCognome.getText().toString(),
                                        Integer.valueOf(mTextViewEta.getText().toString()),
                                        mTextViewTelefono.getText().toString(), value.charAt(0), citta1);

        Account user1 = new Account(mTextViewUsername.getText().toString(),
                                    mTextViewPassword.getText().toString(),
                                    persona1);

        accountList.add(user1);
        Log.d(LOG_TAG, "Account REGISTRATO con successo!");
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, user1);
        setResult(RESULT_OK,replyIntent);
        finish();

    }

}