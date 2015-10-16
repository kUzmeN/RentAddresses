package com.example.vladok.rentaddresses.adapters;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AddressesAdapter  extends CursorAdapter {
    private LayoutInflater inflater;

    public AddressesAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.inflater  = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }
}
