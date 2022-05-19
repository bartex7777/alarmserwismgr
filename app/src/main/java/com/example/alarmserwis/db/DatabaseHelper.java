package com.example.alarmserwis.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int WERSJA = 1;
    private static final String NAZWA_BAZY_DANYCH = "zasoby";
    private static final String NAZWA_TABELI = "zdjecia";
    private static final String ID = "id";
    private static final String ZDJECIE = "zdjecie";
    private static final String OPIS = "opis";

    public DatabaseHelper(Context context) {
        super(context, NAZWA_BAZY_DANYCH, null, WERSJA);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String stworzTabele = "CREATE TABLE " + NAZWA_TABELI + " (" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ZDJECIE + " BLOB, " + OPIS + " TEXT)";
        sqLiteDatabase.execSQL(stworzTabele);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NAZWA_TABELI);
        onCreate(sqLiteDatabase);
    }
}
