package com.example.crudproduct.dto;

import com.example.crudproduct.anotation.Column;
import com.example.crudproduct.anotation.Id;
import com.example.crudproduct.contant.SqlDataType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


public class ProductDto {
    private int id;
    private String name;
    private String model;
    private int price;

    public ProductDto() {

    }

    public ProductDto(int id, String name, String model, int price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
