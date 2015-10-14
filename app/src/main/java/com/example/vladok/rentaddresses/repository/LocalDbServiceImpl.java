package com.example.vladok.rentaddresses.repository;


import android.content.Context;
import android.support.v4.content.CursorLoader;

public class LocalDbServiceImpl extends RepositoryService {

    public LocalDbServiceImpl(Context context) {
        super(context);
    }

    @Override
    public CursorLoader loadInBackground() {
        return null;
        //Cursor cursor = db.getAllData();
    }
}
