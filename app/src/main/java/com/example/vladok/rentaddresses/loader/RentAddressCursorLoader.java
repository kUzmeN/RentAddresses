package com.example.vladok.rentaddresses.loader;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

import com.example.vladok.rentaddresses.repository.contract.Repository;

public class RentAddressCursorLoader extends CursorLoader {
    Repository repository;

    public RentAddressCursorLoader(Context context, Repository repository) {
        super(context);
        this.repository = repository;
    }

    @Override
    public Cursor loadInBackground() {
        Cursor cursor = repository.readAll();
        return cursor;
    }
}
