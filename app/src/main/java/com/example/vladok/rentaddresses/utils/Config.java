package com.example.vladok.rentaddresses.utils;


public class Config {
    public static final String COLUMN_RENT_ADRESS_ID = "_id";
    public static final String COLUMN_RENT_ADRESS_STATE = "state";
    public static final String COLUMN_RENT_ADRESS_CITY = "city";
    public static final String COLUMN_RENT_ADRESS_STREET = "street";
    public static final String COLUMN_RENT_ADRESS_MONTHLY_RENT = "monthlyRent";
    public static final String COLUMN_RENT_ADRESS_LAND_LORD = "landLord";
    public static final String COLUMN_RENT_ADRESS_MOOV_IN = "moovIn";
    public static final String COLUMN_RENT_ADRESS_MOOV_OUT = "moovOut";
    public static final String COLUMN_RENT_ADRESS_RESPONSE = "response";


    public static final String DB_CREATE =
            "create table " + Config.DB_TABLE + "(" +
                    Config.COLUMN_RENT_ADRESS_ID + " integer primary key autoincrement, " +
                    Config.COLUMN_RENT_ADRESS_STATE + " text, " +
                    Config.COLUMN_RENT_ADRESS_CITY + " text, " +
                    Config.COLUMN_RENT_ADRESS_STREET + " text, " +
                    Config.COLUMN_RENT_ADRESS_MONTHLY_RENT + " integer, " +
                    Config.COLUMN_RENT_ADRESS_LAND_LORD + " text, " +
                    Config.COLUMN_RENT_ADRESS_MOOV_IN + " text, " +
                    Config.COLUMN_RENT_ADRESS_MOOV_OUT + " text, " +
                    Config.COLUMN_RENT_ADRESS_RESPONSE + " text" +
                    ");";
    public static final String DB_NAME = "mydb";
    public static final int DB_VERSION = 1;
    public static final String DB_TABLE = "mytab";
}
