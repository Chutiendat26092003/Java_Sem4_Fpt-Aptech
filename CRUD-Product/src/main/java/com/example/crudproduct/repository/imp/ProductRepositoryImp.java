package com.example.crudproduct.repository.imp;

import com.example.crudproduct.entity.Product;
import com.example.crudproduct.jpa.iml.JpaExecutorImpl;
import com.example.crudproduct.repository.ProductRepository;

import java.util.List;


public class ProductRepositoryImp  extends JpaExecutorImpl<Product> implements ProductRepository {
    public ProductRepositoryImp() {
        super(Product.class);
    }

    @Override
    public List<Product> gets() {
        return findall();
    }
}
