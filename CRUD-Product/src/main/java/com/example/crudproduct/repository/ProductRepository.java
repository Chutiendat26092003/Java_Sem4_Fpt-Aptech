package com.example.crudproduct.repository;

import com.example.crudproduct.entity.Product;

import java.util.List;

public interface ProductRepository<Product> {
    List<Product> getAll();
}
