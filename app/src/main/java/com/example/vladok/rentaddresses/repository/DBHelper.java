package com.example.vladok.rentaddresses.repository;


import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.vladok.rentaddresses.util.Config;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            db.beginTransaction();
        try {
            db.execSQL(Config.DB_CREATE);
            db.setTransactionSuccessful();
        } catch (SQLException e) {
            Log.e(Config.LOG_TAG_ERROR, e.toString());
        }finally {
            db.endTransaction();
        }
        ContentValues cv = new ContentValues();

        for (int i = 1; i < 5; i++) {
            cv.put(Config.STATE, "State " + i);
            cv.put(Config.CITY, "City " + i);
            cv.put(Config.STREET, "Street " + i);
            cv.put(Config.MONTHLY_RENT, i);
            cv.put(Config.LAND_LORD, "Landlord " + i);
            cv.put(Config.MOVE_IN, "12/01/200" + i);
            cv.put(Config.MOVE_OUT, "12/01/201" + i);
            cv.put(Config.RESPONSE, "Response " + i);
            db.insert(Config.DB_TABLE_RENT_ADDRESS, null, cv);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
