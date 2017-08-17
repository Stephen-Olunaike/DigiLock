package com.stephen.digilock.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.stephen.digilock.Models.Maker;

import static com.stephen.digilock.Database.DGDatabaseSchema.*;

/**
 * Created by stephen on 17/08/2017.
 */

public class DGCursorWrapper extends CursorWrapper {

    public DGCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Maker extractMaker() {
        long id = getLong(getColumnIndex(MakerTable.MakerCols.ID));
        String secret = getString(getColumnIndex(MakerTable.MakerCols.SECRET));

        return new Maker(id, secret);
    }
}
