package com.example.crudproduct.jpa;

import java.sql.ResultSet;
import java.util.List;

public interface JpaExecutor <T> {
    List<T> findall();
    List<T> entityParser(ResultSet rs);
}
