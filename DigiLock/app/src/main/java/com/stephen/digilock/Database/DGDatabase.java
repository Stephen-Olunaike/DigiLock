package com.stephen.digilock.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.stephen.digilock.Models.Maker;

import static com.stephen.digilock.Database.DGDatabaseSchema.*;

/**
 * Created by stephen on 16/08/2017.
 */

public class DGDatabase {

    private Context context;

    private static final String DG_DEBUG = "DigiDebug";

    public DGDatabase(Context context) {
        this.context = context;
    }

    public void addMaker(Maker m) {
        SQLiteDatabase database = new DGDatabaseHelper(context).getWritableDatabase();

        ContentValues values = Maker.getContentValues(m);

        database.insert(MakerTable.MAKER, null, values);
    }

    public void updateMaker(Maker m) {
        SQLiteDatabase database = new DGDatabaseHelper(context).getWritableDatabase();

        String id = Long.toString(m.getId());

        ContentValues values = Maker.getContentValues(m);

        database.update(MakerTable.MAKER, values,
                MakerTable.MakerCols.ID + " = ?", new String[] {id});
    }

    public Maker getMaker() {
        SQLiteDatabase database = new DGDatabaseHelper(context).getReadableDatabase();

        String selection = "SELECT m.[Id], m.[Secret]" +
                " FROM [KeyMaker] m" +
                " LIMIT 1";

        String selectionArgs[] = {};

        Log.d(DG_DEBUG, "Getting KeyMaker");

        Cursor cursor = database.rawQuery(selection, selectionArgs);

        Maker maker = null;

        try {
            if (cursor.moveToFirst()) maker = new DGCursorWrapper(cursor).extractMaker();

        } catch (Exception e) {
            Log.d(DG_DEBUG, "Error " + e.getMessage());

        } finally {
            cursor.close();
        }

        Log.d(DG_DEBUG, "Extracted " + Long.toString(maker.getId()));

        return maker;
    }
}
