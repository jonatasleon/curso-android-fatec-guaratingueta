package com.jonatasleon.bears;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    List<Bear> bears;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.39.226/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BearService bearService = retrofit.create(BearService.class);

        Call<List<Bear>> callBears = bearService.listBears();

        try {
            callBears.enqueue(new Callback<List<Bear>>() {
                @Override
                public void onResponse(Call<List<Bear>> call, Response<List<Bear>> response) {
                    bears = response.body();

                    ListView lvBears = (ListView) findViewById(R.id.listBear);
                    ArrayAdapter<Bear> adapter = new ArrayAdapter<Bear>(
                            getBaseContext(),
                            android.R.layout.simple_list_item_1,
                            bears);

                    lvBears.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<Bear>> call, Throwable t) {
                    bears = new ArrayList<Bear>();
                    Bear b = new Bear();
                    b.setName("Sem nada");
                    bears.add(b);
                }
            });
        } catch (Exception e) {
            bears = new ArrayList<>();
            e.printStackTrace();
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
