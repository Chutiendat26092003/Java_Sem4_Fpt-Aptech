package com.example.crudproduct.service;

import com.example.crudproduct.dto.ProductDto;
import com.example.crudproduct.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getListProduct();
}
