package com.jonatasleon.atividadei;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jonatasleon on 30/04/16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            EditText editText = (EditText) findViewById(R.id.editText);
            String texto = editText.getText().toString();
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(texto);

            Button button = (Button) v;
            button.setText("Text View está sujo");
            editText.setText("");
        } else if(v.getId() == R.id.button2) {
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText("");

            Button button = (Button) findViewById(R.id.button);
            button.setText("Text View está limpo");
        }
    }
}
