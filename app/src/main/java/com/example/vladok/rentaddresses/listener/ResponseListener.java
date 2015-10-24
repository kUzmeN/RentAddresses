package com.example.vladok.rentaddresses.listener;

import com.example.vladok.rentaddresses.exception.DbQueryException;

public interface ResponseListener {
    void onResponse(String response) throws DbQueryException;
}