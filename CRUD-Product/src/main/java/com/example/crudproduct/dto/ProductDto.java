package com.example.crudproduct.dto;

import com.example.crudproduct.anotation.Column;
import com.example.crudproduct.anotation.Id;
import com.example.crudproduct.contant.SqlDataType;
import lombok.Data;

@Data
public class ProductDto {
    private int id;
    private String name;
    private String model;
    private int price;
}
