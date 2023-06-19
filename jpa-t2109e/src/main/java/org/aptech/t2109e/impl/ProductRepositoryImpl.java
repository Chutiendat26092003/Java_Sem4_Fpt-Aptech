package org.aptech.t2109e.impl;

import org.aptech.t2109e.test.Product;

public class ProductRepositoryImpl extends JpaExecutorImpl<Product>{
    public ProductRepositoryImpl() {
        super(Product.class);
    }

    public Object getAll() {
        return findall();
    }

    @Override
    public Product getById(int id){
        return super.getById(id); // có nguy cơ gây ra đệ quy
    }

    public static void main(String[] args) {
        ProductRepositoryImpl obj = new ProductRepositoryImpl();
        obj.getById(1);
    }
}
