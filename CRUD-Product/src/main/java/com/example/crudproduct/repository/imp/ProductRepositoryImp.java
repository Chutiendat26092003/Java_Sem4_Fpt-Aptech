package com.example.crudproduct.repository.imp;

import com.example.crudproduct.entity.Product;
import com.example.crudproduct.jpa.iml.JpaExecutorImpl;

import java.util.List;

public class ProductRepositoryImp<Product> extends JpaExecutorImpl<Product> {
    public ProductRepositoryImp(Class<Product> clazz) {
        super(clazz);
    }
//    public List<Product> getAll() {
//
//        return null;
//    }

}
