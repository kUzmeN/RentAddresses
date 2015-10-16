package com.example.vladok.rentaddresses.loaders;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

import com.example.vladok.rentaddresses.repository.contracts.Repository;
import com.example.vladok.rentaddresses.repository.impl.RepositoryImpl;

public class RentAddressCursorLoader  extends CursorLoader {
    Repository repository;
    public RentAddressCursorLoader(Context context , RepositoryImpl repository) {
        super(context);
        this.repository = repository;
    }

    @Override
    public Cursor loadInBackground() {
        Cursor cursor = repository.readAll();
        return cursor;
    }
}
