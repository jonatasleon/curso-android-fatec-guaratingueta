package br.com.jonatasleon.primeiraaplicacao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by jonatasleon on 30/04/16.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        final Button button = (Button) findViewById(R.id.main_btn_mensagem);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast mensagem = Toast.makeText(MainActivity.this,
                                "Eu disse para não apertar!",
                                Toast.LENGTH_LONG);
                mensagem.show();
            }
        });
    }
}
