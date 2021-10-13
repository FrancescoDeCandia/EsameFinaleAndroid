package com.example.esamefinaleandroid.attivita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.esamefinaleandroid.R;
import com.example.esamefinaleandroid.entitita.Account;

public class UserDetailsActivity extends AppCompatActivity {

    private TextView dNome;
    private TextView dCognome;
    private TextView dEta;
    private TextView dTelefono;
    private TextView dSesso;
    private TextView dCitta;
    private TextView dProvincia;
    private Account accountLoggato;
    private static final String LOG_TAG = UserDetailsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        dNome = findViewById(R.id.detailNome);
        dCognome = findViewById(R.id.detailCognome);
        dEta = findViewById(R.id.detailEta);
        dTelefono = findViewById(R.id.detailTelefono);
        dSesso = findViewById(R.id.detailSesso);
        dCitta = findViewById(R.id.detailCitta);
        dProvincia = findViewById(R.id.detailProvincia);

        Intent intent = getIntent();
        accountLoggato = intent.getParcelableExtra(LoginActivity.EXTRA_MESSAGE);
        Log.d(LOG_TAG, "Recuperato l'oggetto ACCOUNT loggato tramite la Login Activity");
        Log.d(LOG_TAG, "Setto gli attributi della PERSONA a video");
        dNome.setText(accountLoggato.getPersona().getNome());
        dCognome.setText(accountLoggato.getPersona().getCognome());
        dEta.setText(accountLoggato.getPersona().getEta().toString());
        dTelefono.setText(accountLoggato.getPersona().getTelefono());
        dSesso.setText(accountLoggato.getPersona().getSesso().toString());
        dCitta.setText(accountLoggato.getPersona().getCitta().getNome());
        dProvincia.setText(accountLoggato.getPersona().getCitta().getProvincia());

    }
}