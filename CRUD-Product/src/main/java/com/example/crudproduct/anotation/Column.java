package com.example.crudproduct.anotation;

import com.example.crudproduct.contant.SqlDataType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
    // mapping attribute object in app <--> column of table in db
    String name();
    SqlDataType dataType();
}
