package com.jonatasleon.dialogs;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String DATE_PICKER_TAG = "DATE_PICKER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void mostrarDialog(View v) {
        AlertDialog dialog = new AlertDialog.Builder(this)
            .setTitle("Meu Dialogo")
            .setMessage("Uma mensagem para o dialogo")
            .setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "SIM!!!", Toast.LENGTH_SHORT)
                            .show();
                }
            })
            .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "NÃO!!!", Toast.LENGTH_SHORT)
                            .show();
                }
            })
            .create();

        dialog.show();
    }

    public void mostrarDatePicker(View v) {
        DatePickerFragment datePicker = new DatePickerFragment();
        datePicker.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String data = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT)
                        .show();
            }
        });
        datePicker.show(getFragmentManager(), "DATE_PICKER");
    }
}
