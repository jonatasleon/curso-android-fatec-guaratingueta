package com.jonatasleon.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jonatasleon on 04/06/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "Escola";

    public DBHelper(Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE alu_aluno (" +
                            "alu_codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
                            "alu_ra TEXT NOT NULL," +
                            "alu_nome TEXT NOT NULL" +
                        ")";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
