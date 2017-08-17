package com.stephen.digilock.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.stephen.digilock.Database.DGDatabaseSchema.*;

/**
 * Created by stephen on 09/08/2017.
 */

public class DGDatabaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "digilock.db";

    public DGDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table" +
                " " + MakerTable.MAKER + "(" +
                " Id integer primary key autoincrement," +
                " " + MakerTable.MakerCols.SECRET + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
