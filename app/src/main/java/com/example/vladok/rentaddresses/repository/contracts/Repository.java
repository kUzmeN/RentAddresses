package com.example.vladok.rentaddresses.repository.contracts;


import android.database.Cursor;

import com.example.vladok.rentaddresses.domain.BaseEntity;

public interface Repository<T extends BaseEntity> {
    void open();
    void close();
    Cursor readAll();
    Cursor readOne(int id);
    void save(T entity);
    void delete(int id);
}
