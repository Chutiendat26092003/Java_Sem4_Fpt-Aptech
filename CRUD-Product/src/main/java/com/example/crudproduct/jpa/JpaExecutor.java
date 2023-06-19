package com.example.crudproduct.jpa;

import java.sql.ResultSet;
import java.util.List;

public interface JpaExecutor <T> {
    List<T> findall();
    T getById(int id);
    T getByField(String fieldName, String valueName);
    List<T> entityParser(ResultSet rs);
}
