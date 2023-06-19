package com.example.crudproduct.entity;

import com.example.crudproduct.anotation.Column;
import com.example.crudproduct.anotation.Entity;
import com.example.crudproduct.anotation.Id;
import com.example.crudproduct.contant.SqlDataType;

@Entity(tablename = "user")
public class Product {
    @Id(name = "id")
    private int id;
    @Column(name = "name", dataType = SqlDataType.TEXT)
    private String name;
    @Column(name = "model", dataType = SqlDataType.TEXT)
    private String model;
    @Column(name = "price", dataType = SqlDataType.INTEGER)
    private int price;
}
