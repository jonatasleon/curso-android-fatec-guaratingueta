package com.jonatasleon.atividadeii;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Button) findViewById(R.id.soma)).setOnClickListener(this);
        ((Button) findViewById(R.id.subtracao)).setOnClickListener(this);
        ((Button) findViewById(R.id.multiplicacao)).setOnClickListener(this);
        ((Button) findViewById(R.id.divisao)).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int n1 = Integer.parseInt(((EditText) findViewById(R.id.n1)).getText().toString());
        int n2 = Integer.parseInt(((EditText) findViewById(R.id.n2)).getText().toString());
        double res = 0;

        switch (v.getId()){
            case R.id.soma:
                res = n1 + n2;
                break;
            case R.id.subtracao:
                res = n1 - n2;
                break;
            case R.id.multiplicacao:
                res = n1 * n2;
                break;
            case R.id.divisao:
                res = n1 / n2;
                break;
        }

        ((TextView) findViewById(R.id.res)).setText(String.valueOf(res));
    }
}
