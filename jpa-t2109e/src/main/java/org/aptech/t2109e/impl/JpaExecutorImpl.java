package org.aptech.t2109e.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2109e.JpaExecutor;
import org.aptech.t2109e.anotation.Column;
import org.aptech.t2109e.anotation.Entity;
import org.aptech.t2109e.anotation.Id;
import org.aptech.t2109e.config.db.DBConnection;
import org.aptech.t2109e.contant.SqlStat;
import org.aptech.t2109e.ultis.SelectQueryBuilder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JpaExecutorImpl<T> implements JpaExecutor<T> {

    private Class<T> clazz;
    private String className;
    private String tableName;

    public JpaExecutorImpl(Class<T> clazz){
        this.clazz = clazz;
        this.className = clazz.getSimpleName();
        this.tableName = (clazz.getAnnotation(Entity.class) != null) ? clazz.getAnnotation(Entity.class).tablename() :
                this.className.toLowerCase();
    }

    public List<T> entityParser(ResultSet rs){
        List<T> entitys = new ArrayList<>();
        try {
            while(rs.next()){
                T entity = clazz.getDeclaredConstructor().newInstance();
                for(Field f : entity.getClass().getDeclaredFields()){
                    String columnName = f.getName();
                    if (f.isAnnotationPresent(Column.class) && !StringUtils.isEmpty(f.getAnnotation(Column.class).name())){
                        Column columnInfo = f.getAnnotation(Column.class);
                        columnName = columnInfo.name();
                        f.setAccessible(true);
                        switch (columnInfo.dataType()){
                            case INTEGER: f.set(entity, rs.getInt(columnName));
                                break;
                            case TEXT: f.set(entity, rs.getString(columnName));
                                break;
                            case BIG_INTEGER: f.set(entity, rs.getInt(columnName));
                                break;
                            case SMALL_INTEGER: f.set(entity, rs.getInt(columnName));
                                break;
                            case DATE: f.set(entity, rs.getDate(columnName));
                                break;
                            case FLOAT: f.set(entity, rs.getFloat(columnName));
                                break;
                            case DOUBLE: f.set(entity, rs.getInt(columnName));
                                break;
                            // todo : Làm tiếp tục với các kiểu dữ liệu còn lại
                            // fixme: Fix nốt đê
                        }
                    }
                }
                entitys.add(entity);
            }
        }
        catch (SQLException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new RuntimeException();
        }

        return entitys;
    }
    public List<T> findall(){
        Connection conn = null;
        try {
            conn = DBConnection.getInstance().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if(conn == null) {
            // todo: log
            System.err.println("Connection is null" + conn);
        } else {
            System.err.println(conn);
        }

        StringBuilder statement = new StringBuilder().append(SqlStat.SELECT_ASTERISK.value)
                .append(SqlStat.SPACE.value).append(SqlStat.FROM).append(SqlStat.SPACE.value).append(tableName);

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(statement.toString());
            ResultSet rs = preparedStatement.executeQuery();
//            String title = rs.getString("title");
            return entityParser(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T getById(int id) {
        SelectQueryBuilder select = new SelectQueryBuilder(tableName);
        String idColumnName = null;
        for (Field f: clazz.getDeclaredFields()){
            if (f.isAnnotationPresent(Id.class)){
                idColumnName = f.getAnnotation(Id.class).name();
            }
        }
        select.andClause(idColumnName + " = ?");
        System.err.println(select.getQuery());
        return null;
    }
}
