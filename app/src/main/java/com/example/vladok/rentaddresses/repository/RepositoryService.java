package com.example.vladok.rentaddresses.repository;


import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.CursorLoader;

public abstract class RepositoryService extends AsyncTaskLoader<CursorLoader> {

    public RepositoryService(Context context) {
        super(context);
    }
}
