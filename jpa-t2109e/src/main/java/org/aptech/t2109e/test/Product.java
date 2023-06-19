package org.aptech.t2109e.test;

import org.aptech.t2109e.anotation.Column;
import org.aptech.t2109e.anotation.Entity;
import org.aptech.t2109e.anotation.Id;
import org.aptech.t2109e.contant.SqlDataType;

@Entity(tablename = "product_table")
public class Product {
    @Id(name = "product_id")
    private Long id;
    @Column(name = "product_name", dataType = SqlDataType.TEXT)
    private String name;
}
