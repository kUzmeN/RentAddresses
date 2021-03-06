package com.example.vladok.rentaddresses.repository.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.vladok.rentaddresses.domain.BaseEntity;
import com.example.vladok.rentaddresses.repository.DBHelper;
import com.example.vladok.rentaddresses.repository.contract.Repository;
import com.example.vladok.rentaddresses.util.Config;

public abstract class RepositoryImpl<T extends BaseEntity> implements Repository<T> {

    private final Context mCtx;
    private DBHelper mDBHelper;
    SQLiteDatabase mDB;

    public RepositoryImpl(Context ctx) {
        mCtx = ctx;
    }


    @Override
    public void open() {
        mDBHelper = new DBHelper(mCtx, Config.DB_NAME, null, Config.DB_VERSION);
        mDB = mDBHelper.getWritableDatabase();
    }

    @Override
    public void close() {
        if (mDBHelper != null) mDBHelper.close();
    }


}
