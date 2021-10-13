package com.example.esamefinaleandroid.attivita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.esamefinaleandroid.R;
import com.example.esamefinaleandroid.entitita.Account;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE_1 = "com.example.esamefinaleandroid.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyTextView1;
    private TextView mReplyTextView2;
    private TextView mReplyTextView3;
    private TextView mReplyTextView4;
    private TextView mReplyTextView5;
    private TextView mReplyTextView6;
    private TextView mTextViewNomeCognome;
    private Account accountLoggato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextViewNomeCognome = findViewById(R.id.textViewNomeCognome);
        mReplyTextView1 = findViewById(R.id.show_item1);
        mReplyTextView2 = findViewById(R.id.show_item2);
        mReplyTextView3 = findViewById(R.id.show_item3);
        mReplyTextView4 = findViewById(R.id.show_item4);
        mReplyTextView5 = findViewById(R.id.show_item5);
        mReplyTextView6 = findViewById(R.id.show_item6);

        Toast toast = Toast.makeText(this, "Login effettuato correttamente !", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = getIntent();
        accountLoggato = intent.getParcelableExtra(LoginActivity.EXTRA_MESSAGE);
        String nomeCognome =  (accountLoggato.getPersona().getNome() + " " + accountLoggato.getPersona().getCognome());
        mTextViewNomeCognome.setText(nomeCognome);

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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(AddProductsActivity.EXTRA_REPLY);

                Toast toast = Toast.makeText(this, "Prodotto correttamente !", Toast.LENGTH_SHORT);
                toast.show();

                if (mReplyTextView1.getText().toString().isEmpty()) {
                    mReplyTextView1.setVisibility(View.VISIBLE);
                    mReplyTextView1.setText(reply);
                } else if (mReplyTextView2.getText().toString().isEmpty()) {
                    mReplyTextView2.setVisibility(View.VISIBLE);
                    mReplyTextView2.setText(reply);
                } else if (mReplyTextView3.getText().toString().isEmpty()) {
                    mReplyTextView3.setVisibility(View.VISIBLE);
                    mReplyTextView3.setText(reply);
                } else if (mReplyTextView4.getText().toString().isEmpty()) {
                    mReplyTextView4.setVisibility(View.VISIBLE);
                    mReplyTextView4.setText(reply);
                } else if (mReplyTextView5.getText().toString().isEmpty()) {
                    mReplyTextView5.setVisibility(View.VISIBLE);
                    mReplyTextView5.setText(reply);
                } else if (mReplyTextView6.getText().toString().isEmpty()) {
                    mReplyTextView6.setVisibility(View.VISIBLE);
                    mReplyTextView6.setText(reply);
                } else Log.d(LOG_TAG, "Non puoi più aggiungere altri items!");
            }
        }
    }
}