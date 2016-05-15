package com.jonatasleon.listviewprojeto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCidades = (ListView) findViewById(R.id.lv_cidades);

        String[] cidades = {
                "Guaratingueta", "Aparecida", "Lorena",
                "Piquete", "Cunha", "Putim", "Canas", "Cruzeiro",
                "Cachoeira Paulista", "Roseira", "Pindamonhangaba",
                "Taubaté", "Tremembé", "São José dos Campos do Jordão"
        };

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cidades);

        lvCidades.setAdapter(adapter);
        lvCidades.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT);
        String cidade;

        cidade = parent.getItemAtPosition(position).toString();
        toast.setText("Você clicou em " + cidade);
        toast.show();
    }
}
