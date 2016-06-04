package com.jonatasleon.persistencia;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class SharedPreferenceActivity extends AppCompatActivity {

    private static final String PESSOA_KEY = "pessoa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        Button btnPrefs = (Button) findViewById(R.id.btn_salvar);
        btnPrefs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.edt_nome);
                salvarNome(editText.getText().toString());
                editText.setText("");
                Toast.makeText(SharedPreferenceActivity.this, "Nome salvo", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnLer = (Button) findViewById(R.id.btn_exibir);
        btnLer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SharedPreferenceActivity.this, lerNome(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void salvarNome(String nome) {
        SharedPreferences prefs = getSharedPreferences(PESSOA_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("nome", nome);

        editor.apply();
    }

    private String lerNome() {
        SharedPreferences prefs = getSharedPreferences(PESSOA_KEY, MODE_PRIVATE);
        String nome = prefs.getString("nome", "Não há um nome salvo");

        return nome;
    }


}
