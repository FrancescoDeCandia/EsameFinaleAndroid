package com.example.esamefinaleandroid.attivita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.esamefinaleandroid.R;
import com.example.esamefinaleandroid.entitita.Account;
import com.example.esamefinaleandroid.entitita.WordListAdapter;


import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE_1 = "com.example.esamefinaleandroid.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView mTextViewNomeCognome;
    private Account accountLoggato;

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mRecyclerView = findViewById(R.id.recyclerview);
        mTextViewNomeCognome = findViewById(R.id.textViewNomeCognome);

        Intent intent = getIntent();
        accountLoggato = intent.getParcelableExtra(LoginActivity.EXTRA_MESSAGE);
        String nomeCognome = (accountLoggato.getPersona().getNome() + " " + accountLoggato.getPersona().getCognome());
        mTextViewNomeCognome.setText(nomeCognome);

        if (savedInstanceState != null) {
            mAdapter = new WordListAdapter(this, mWordList);
            mRecyclerView.setAdapter(mAdapter);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            Integer j = savedInstanceState.size();

            for (Integer i = 0; i <= j; i++)
                mWordList.add(savedInstanceState.getString(String.valueOf(i)));

        }
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
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String word = data.getStringExtra(AddProductsActivity.EXTRA_REPLY);
                mWordList.addLast(word);

                mAdapter = new WordListAdapter(this, mWordList);
                mRecyclerView.setAdapter(mAdapter);
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

                System.out.println("Prodotto aggiunto con successo!");
            }
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!mWordList.isEmpty()) {
            Integer i = 0;
            for (String s : mWordList) {
                outState.putString(String.valueOf(i), s);
                i++;
            }
        }
    }

}