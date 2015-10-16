package com.example.vladok.rentaddresses.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.vladok.rentaddresses.domain.RentAddress;
import com.example.vladok.rentaddresses.repository.contracts.RentAddressRepository;
import com.example.vladok.rentaddresses.utils.Config;

public class RentAddressRepositoryImpl extends RepositoryImpl<RentAddress>  implements RentAddressRepository{

    public RentAddressRepositoryImpl(Context ctx) {
        super(ctx);
    }

    @Override
    public Cursor readOne(int id) {
        return null;
    }

    @Override
    public void save(RentAddress rentAddress) {
        ContentValues cv = new ContentValues();
        cv.put(Config.COLUMN_RENT_ADRESS_STATE, rentAddress.getState());
        cv.put(Config.COLUMN_RENT_ADRESS_CITY, rentAddress.getCity());
        cv.put(Config.COLUMN_RENT_ADRESS_STREET, rentAddress.getStreet());
        cv.put(Config.COLUMN_RENT_ADRESS_MONTHLY_RENT, rentAddress.getMonthlyRent());
        cv.put(Config.COLUMN_RENT_ADRESS_LAND_LORD, rentAddress.getLandLord());
        cv.put(Config.COLUMN_RENT_ADRESS_MOOV_IN, rentAddress.getMoovIn());
        cv.put(Config.COLUMN_RENT_ADRESS_MOOV_OUT, rentAddress.getMoovOut());
        cv.put(Config.COLUMN_RENT_ADRESS_RESPONSE, rentAddress.getResponse());
        mDB.insert(Config.DB_TABLE, null, cv);
    }

    @Override
    public Cursor readAll() {
        return mDB.query(Config.DB_TABLE, null, null, null, null, null, null);
    }

    @Override
    public void delete(int id) {
        mDB.delete(Config.DB_TABLE, Config.COLUMN_RENT_ADRESS_ID + " = " + id, null);
    }
}
