package com.example.vladok.rentaddresses.util;

import android.app.Application;
import android.content.Context;


public class MyContext extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }
}