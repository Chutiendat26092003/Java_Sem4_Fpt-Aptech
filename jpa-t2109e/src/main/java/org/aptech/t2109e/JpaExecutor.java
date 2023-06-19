package org.aptech.t2109e;

import java.sql.ResultSet;
import java.util.List;

public interface JpaExecutor<T> {
    List<T> findall();
    T getById(int id);
    List<T> entityParser(ResultSet rs);
}
