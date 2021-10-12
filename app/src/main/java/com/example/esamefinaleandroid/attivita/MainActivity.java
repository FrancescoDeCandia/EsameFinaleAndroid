package com.example.esamefinaleandroid.attivita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.esamefinaleandroid.R;
import com.example.esamefinaleandroid.entitita.Account;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE_1 = "com.example.esamefinaleandroid.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView mTextViewNome;
    private TextView mTextViewCognome;
    private Account accountLoggato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextViewNome = findViewById(R.id.textViewNome);
        mTextViewCognome = findViewById(R.id.textViewCognome);

        Intent intent = getIntent();
        accountLoggato = intent.getParcelableExtra(LoginActivity.EXTRA_MESSAGE);
        String nome =  accountLoggato.getPersona().getNome();
        String cognome = accountLoggato.getPersona().getCognome();
        mTextViewNome.setText(nome);
        mTextViewCognome.setText(cognome);

    }

    public void launchUserDetailsActivity(View view) {
        Log.d(LOG_TAG, "Effettuato Click sul nome dell'utente!");
        Intent intent = new Intent(this, UserDetailsActivity.class);
        intent.putExtra(EXTRA_MESSAGE_1, accountLoggato);
        Log.d(LOG_TAG, "Passato l'oggetto ACCOUNT all'User Details Activity");
        startActivity(intent);
    }

    public void launchAddProductsActivity(View view) {
        Log.d(LOG_TAG, "Button ADD PRODUCTS clicked!");
        Intent intent = new Intent(this, AddProductsActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}