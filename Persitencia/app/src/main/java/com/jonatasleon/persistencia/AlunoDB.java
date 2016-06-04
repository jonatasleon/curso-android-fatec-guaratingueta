package com.jonatasleon.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonatasleon on 04/06/16.
 */
public class AlunoDB {

    private DBHelper dbHelper;

    public AlunoDB(Context context) {
        dbHelper = new DBHelper(context);
    }

    public long insert(Aluno aluno) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("alu_ra", aluno.ra);
        cv.put("alu_nome", aluno.nome);

        long codigo = db.insert("alu_aluno", null, cv);
        db.close();

        return codigo;
    }

    public int update(Aluno aluno) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("alu_ra", aluno.ra);
        cv.put("alu_nome", aluno.nome);

        int linhas = db.update(
                "alu_aluno",
                cv,
                "alu_codigo = ?",
                new String[]{ String.valueOf(aluno.codigo) });

        db.close();

        return linhas;
    }

    public int delete(Aluno aluno) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        int linhas = db.delete(
                "alu_aluno",
                "alu_codigo = ?",
                new String[]{ String.valueOf(aluno.codigo) });

        db.close();

        return linhas;
    }

    public Aluno selectById(long codigo) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query;
        query = "SELECT alu_codigo, alu_ra, alu_nome FROM alu_aluno WHERE alu_codigo = ?";

        Cursor cursor = db.rawQuery(query, new String[]{ String.valueOf(codigo) });

        Aluno aluno = new Aluno();

        while(cursor.moveToNext()) {
            aluno.codigo = cursor.getLong(cursor.getColumnIndex("alu_codigo"));
            aluno.ra = cursor.getString(cursor.getColumnIndex("alu_ra"));
            aluno.nome = cursor.getString(cursor.getColumnIndex("alu_nome"));
        }
        cursor.close();

        return aluno;
    }

    public List<Aluno> selectAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String query = "SELECT alu_codigo, alu_ra, alu_nome FROM alu_aluno";
        Cursor cursor = db.rawQuery(query, new String[]{});

        List<Aluno> alunos = new ArrayList<>();
        while(cursor.moveToNext()) {
            Aluno aluno = new Aluno();
            aluno.codigo = cursor.getLong(cursor.getColumnIndex("alu_codigo"));
            aluno.ra = cursor.getString(cursor.getColumnIndex("alu_ra"));
            aluno.nome = cursor.getString(cursor.getColumnIndex("alu_nome"));
            alunos.add(aluno);
        }
        cursor.close();

        return alunos;
    }
}
