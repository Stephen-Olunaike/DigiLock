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

    public Maker addMaker(Maker m) {
        SQLiteDatabase database = new DGDatabaseHelper(context).getWritableDatabase();

        ContentValues values = Maker.getContentValues(m);

        Log.d(DG_DEBUG, "Adding KeyMaker");
        long id = database.insert(MakerTable.MAKER, null, values);

        m.setId(id);

        return m;
    }

    public void updateMaker(Maker m) {
        SQLiteDatabase database = new DGDatabaseHelper(context).getWritableDatabase();

        ContentValues values = Maker.getContentValues(m);

        String selection = "[Id]=?";

        String selectionArgs[] = {Long.toString(m.getId())};

        Log.d(DG_DEBUG, "Updating KeyMaker");
        database.update(MakerTable.MAKER, values,
                selection, selectionArgs);
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

        return maker;
    }
}
