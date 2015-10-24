package com.example.vladok.rentaddresses.util;


public class Config {
    public static final String ID = "_id";
    public static final String STATE = "state";
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String MONTHLY_RENT = "monthlyRent";
    public static final String LAND_LORD = "landLord";
    public static final String MOVE_IN = "moveIn";
    public static final String MOVE_OUT = "moveOut";
    public static final String RESPONSE = "response";


    public static final String URL ="http://posttestserver.com/post.php";

    public static final String LOG_TAG_ERROR = "errorLog";
    public static final String ERROR_DELETED = "Row was not deleted";
    public static final String ERROR_CREATE = "Query was not applied";
    public static final String ERROR_UPDATE = "Row was not updated";
    public static final String ERROR_AFTER_TXT_CHANGED = "after text changed";
    public static final String ERROR_BEFORE_VALIDATE = "textView is null. PLease use setTextView(..) method before";

    public static final String DB_CREATE =
            "create table " + Config.DB_TABLE_RENT_ADDRESS + "(" +
                    Config.ID + " integer primary key autoincrement, " +
                    Config.STATE + " text, " +
                    Config.CITY + " text, " +
                    Config.STREET + " text, " +
                    Config.MONTHLY_RENT + " integer, " +
                    Config.LAND_LORD + " text, " +
                    Config.MOVE_IN + " text, " +
                    Config.MOVE_OUT + " text, " +
                    Config.RESPONSE + " text" +
                    ");";
    public static final String DB_NAME = "RentAddressesDB";
    public static final int DB_VERSION = 1;
    public static final String DB_TABLE_RENT_ADDRESS = "RentAddress";
    public static final String NO_RESPONSE ="there is no response" ;
    public static final String DATE_FORMAT = "dd/MM/yyyy";

}
