package com.example.vladok.rentaddresses.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;

import com.example.vladok.rentaddresses.R;
import com.example.vladok.rentaddresses.domain.RentAddress;
import com.example.vladok.rentaddresses.exception.DbQueryException;
import com.example.vladok.rentaddresses.repository.contract.RentAddressRepository;
import com.example.vladok.rentaddresses.util.CommonConverter;
import com.example.vladok.rentaddresses.util.Config;
import com.example.vladok.rentaddresses.util.MyContext;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class RentAddressRepositoryImpl extends RepositoryImpl<RentAddress> implements RentAddressRepository {

    @Bean
    CommonConverter converter;

    public RentAddressRepositoryImpl(Context ctx) {
        super(ctx);
    }

    @Override
    public Cursor readOne(int id) {
        return null;
    }



    @Override
    public void update(RentAddress entity, long position) throws DbQueryException {
        ContentValues cv = converter.rentAddressToContentValues(entity);
        int rows = 0;
        mDB.beginTransaction();
        try {
            rows = mDB.update(Config.DB_TABLE_RENT_ADDRESS, cv, "_id = ?", new String[]{String.valueOf(position)});
            mDB.setTransactionSuccessful();
        }finally {
            mDB.endTransaction();
        }

        if(rows == 0){
            throw new DbQueryException(Config.ERROR_UPDATE);
        }
    }


    @Override
    public long create(RentAddress rentAddress) throws DbQueryException {
        ContentValues cv = converter.rentAddressToContentValues(rentAddress);
        long id ;
        mDB.beginTransaction();
        try {
            id = mDB.insert(Config.DB_TABLE_RENT_ADDRESS, null, cv);
            mDB.setTransactionSuccessful();
        }finally {
            mDB.endTransaction();
        }
        if(id == -1) {
            throw new DbQueryException(Config.ERROR_CREATE);
        }
        return id;
    }

    @Override
    public Cursor readAll() {

         return mDB.query(Config.DB_TABLE_RENT_ADDRESS, null, null, null, null, null, null);
    }

    @Override
    public void delete(long id) throws DbQueryException {
        int rows;
        mDB.beginTransaction();
        try {

            rows = mDB.delete(Config.DB_TABLE_RENT_ADDRESS, Config.ID + " = " + id, null);
            mDB.setTransactionSuccessful();
        }finally {
            mDB.endTransaction();
        }

        if(rows == 0){
            throw new DbQueryException(Config.ERROR_DELETED);
        }
    }


    @Override
    public String readResponse(long id) {
        String str = "noresponse";
        str=  MyContext.getContext().getResources().getString(R.string.no_response);
      (R.string.no_response);
        String selection = Config.ID + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor c = mDB.query(Config.DB_TABLE_RENT_ADDRESS, null, selection, selectionArgs, null, null, null);


        if (c != null) {
            if (c.moveToFirst()) {
                do {
                   str =  c.getString(c.getColumnIndex(Config.RESPONSE));
                } while (c.moveToNext());
            }
            c.close();
        }

        return  str;
    }


}
