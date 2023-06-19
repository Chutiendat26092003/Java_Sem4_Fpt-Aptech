package org.aptech.t2109e.anotation;


import org.aptech.t2109e.contant.SqlDataType;

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
