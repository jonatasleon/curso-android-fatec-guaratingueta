package com.jonatasleon.listviewprojeto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SitesActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sites);

        List<Sites> sites = new ArrayList<>();

        Sites google = new Sites();
        google.setNome("Google");
        google.setUrl("https://google.com.br");
        sites.add(google);

        Sites github = new Sites();
        github.setNome("Github");
        github.setUrl("https://github.com");
        sites.add(github);

        ArrayAdapter<Sites> adapter;
        adapter = new ArrayAdapter<Sites>(this, android.R.layout.simple_list_item_1, sites);

        ListView lvSites = (ListView) findViewById(R.id.lvSites);
        lvSites.setAdapter(adapter);
        lvSites.setOnItemClickListener(this);




        Spinner spnSites = (Spinner) findViewById(R.id.spn_sites);
        ArrayAdapter<Sites> adapterSpn;
        adapterSpn = new ArrayAdapter<Sites>(this,
                                             android.R.layout.simple_spinner_item,
                                             sites);

        spnSites.setAdapter(adapterSpn);
        spnSites.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Sites site = (Sites)parent.getItemAtPosition(position);

                Toast.makeText(
                        SitesActivity.this,
                        site.getUrl(),
                        Toast.LENGTH_SHORT
                ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(SitesActivity.this, "Nenhum item selecionado",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Sites site = (Sites) parent.getItemAtPosition(position);
        Uri uri = Uri.parse(site.getUrl());

        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
