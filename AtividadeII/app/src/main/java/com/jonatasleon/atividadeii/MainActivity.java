package com.jonatasleon.atividadeii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtN1;
    private EditText edtN2;

    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtN1 = (EditText) findViewById(R.id.edt_n1);
        edtN2 = (EditText) findViewById(R.id.edt_n2);

        tvResultado = (TextView) findViewById(R.id.tv_resultado);

        Button btnSoma = (Button) findViewById(R.id.btn_soma);
        btnSoma.setOnClickListener(this);

        Button btnSubtracao = (Button) findViewById(R.id.btn_subtracao);
        btnSubtracao.setOnClickListener(this);

        Button btnMultiplicacao = (Button) findViewById(R.id.btn_multiplicacao);
        btnMultiplicacao.setOnClickListener(this);

        Button btnDivisao = (Button) findViewById(R.id.btn_divisao);
        btnDivisao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double resultado = 0.0;
        int n1, n2;
        n1 = Integer.parseInt(edtN1.getText().toString());
        n2 = Integer.parseInt(edtN2.getText().toString());

        int id = v.getId();

        if(id == R.id.btn_soma) {
            resultado = n1 + n2;
        } else if (id == R.id.btn_subtracao) {
            resultado = n1 - n2;
        } else if (id == R.id.btn_multiplicacao) {
            resultado = n1 * n2;
        } else if (id == R.id.btn_divisao) {
            if(n2 == 0) {
                tvResultado.setText(R.string.aviso_numero_invalido);
                return;
            }
            resultado = n1 / n2;
        }

        tvResultado.setText(String.valueOf(resultado));
    }
}
