package com.example.crudproduct;

import com.example.crudproduct.entity.Product;
import com.example.crudproduct.repository.imp.ProductRepositoryImp;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProductRepositoryImp productRepositoryImp = new ProductRepositoryImp(Product.class);
        List<Product> productList = productRepositoryImp.findall();
        System.err.println(productList);
    }
}
