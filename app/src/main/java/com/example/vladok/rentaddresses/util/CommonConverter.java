package com.example.vladok.rentaddresses.util;


import android.content.ContentValues;

import com.example.vladok.rentaddresses.domain.RentAddress;
import com.example.vladok.rentaddresses.util.Config;

import org.androidannotations.annotations.EBean;

import java.util.HashMap;
import java.util.Map;

@EBean
public class CommonConverter {

    public Map<String, String> entityToMap(RentAddress entity) {

        Map<String, String> map = new HashMap<>();
        map.put(Config.STATE, String.valueOf(entity.getState()));
        map.put(Config.CITY, String.valueOf(entity.getCity()));
        map.put(Config.STREET, String.valueOf(entity.getStreet()));
        map.put(Config.MONTHLY_RENT, String.valueOf(entity.getMonthlyRent()));
        map.put(Config.LAND_LORD, String.valueOf(entity.getLandLord()));
        map.put(Config.MOVE_IN, String.valueOf(entity.getMoveIn()));
        map.put(Config.MOVE_OUT, String.valueOf(entity.getMoveOut()));
        return map;

    }
    public ContentValues rentAddressToContentValues(RentAddress rentAddress) {
        ContentValues cv = new ContentValues();
        cv.put(Config.STATE, rentAddress.getState());
        cv.put(Config.CITY, rentAddress.getCity());
        cv.put(Config.STREET, rentAddress.getStreet());
        cv.put(Config.MONTHLY_RENT, rentAddress.getMonthlyRent());
        cv.put(Config.LAND_LORD, rentAddress.getLandLord());
        cv.put(Config.MOVE_IN, rentAddress.getMoveIn());
        cv.put(Config.MOVE_OUT, rentAddress.getMoveOut());
        cv.put(Config.RESPONSE, rentAddress.getResponse());
        return cv;
    }

}
