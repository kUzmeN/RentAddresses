package com.example.vladok.rentaddresses.notificationService.impl;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.vladok.rentaddresses.domain.RentAddress;
import com.example.vladok.rentaddresses.exception.DbQueryException;
import com.example.vladok.rentaddresses.listener.ResponseListener;
import com.example.vladok.rentaddresses.notificationService.CustomRequest;
import com.example.vladok.rentaddresses.notificationService.contract.NotificationServiceApi;
import com.example.vladok.rentaddresses.util.CommonConverter;
import com.example.vladok.rentaddresses.util.Config;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.Map;

@EBean
public class NotificationServiseApiImpl implements NotificationServiceApi, Response.Listener<String>, Response.ErrorListener {
    @Bean
    CommonConverter converter;
    private Map<String, String> params;
    private RequestQueue requestQueue;
    private CustomRequest jsObjRequest;
    private ResponseListener listener;

    @Override
    public void sendNotification(Context context, RentAddress entity) {
        converter = new CommonConverter();
        params = converter.entityToMap(entity);
        requestQueue = Volley.newRequestQueue(context);
        jsObjRequest = new CustomRequest(Request.Method.POST, Config.URL, params, this, this);
        requestQueue.add(jsObjRequest);


    }

    @Override
    public void setResponseListener(ResponseListener responseListener) {
        this.listener = responseListener;
    }


    @Override
    public void onResponse(String strResponse) {
        try {
            listener.onResponse(strResponse);
        } catch (DbQueryException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        try {
            listener.onResponse(error.toString());
        } catch (DbQueryException e) {
            e.printStackTrace();
        }
    }
}
