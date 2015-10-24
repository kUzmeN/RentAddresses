package com.example.vladok.rentaddresses.repository.contract;


import android.database.Cursor;

import com.example.vladok.rentaddresses.domain.BaseEntity;
import com.example.vladok.rentaddresses.exception.DbQueryException;


public interface Repository<T extends BaseEntity> {
    void open();

    void close();

    long create(T entity) throws DbQueryException;

    Cursor readAll();

    Cursor readOne(int id);

    void update(T entity, long position) throws DbQueryException;

    void delete(long id) throws DbQueryException;
}
