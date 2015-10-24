package com.example.vladok.rentaddresses.adapter;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vladok.rentaddresses.R;
import com.example.vladok.rentaddresses.util.Config;

import org.androidannotations.annotations.EBean;

@EBean
public class AddressesAdapter extends CursorAdapter {
    private LayoutInflater inflater;

    public AddressesAdapter(Context context) {
        super(context, null, 0);
        this.inflater = LayoutInflater.from(context);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return inflater.inflate(R.layout.item_addresses, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvAddress = (TextView) view.findViewById(R.id.tvListRentAddress);
        TextView tvMoveOut = (TextView) view.findViewById(R.id.tvListMoveOutDate);

        tvAddress.setText(cursor.getString(cursor.getColumnIndex(Config.STREET)));
        tvMoveOut.setText(cursor.getString(cursor.getColumnIndex(Config.MOVE_OUT)));
    }
}
