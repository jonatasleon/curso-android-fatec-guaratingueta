package com.jonatasleon.persistencia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arquivo);
    }

    private void salvarTexto(String texto) throws IOException {
        FileOutputStream fos = openFileOutput("arquivo.txt", MODE_PRIVATE);

        String[] linhas = TextUtils.split(texto, "\n");

        PrintWriter writer = new PrintWriter(fos);

        for(String linha : linhas) {
            writer.println(linha);
        }

        writer.flush();
        writer.close();
    }

    private String lerTexto() throws IOException {
        FileInputStream fis = openFileInput("arquivo.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder sbTexto = new StringBuilder();

        String linha;

        while((linha = br.readLine()) != null) {
            if (sbTexto.length() > 0) sbTexto.append("\n");
            sbTexto.append(linha);
        }

        return sbTexto.toString();
    }
}
