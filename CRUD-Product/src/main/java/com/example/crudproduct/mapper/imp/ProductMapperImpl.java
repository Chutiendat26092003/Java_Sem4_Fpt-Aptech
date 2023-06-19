package com.example.crudproduct.mapper.imp;

import com.example.crudproduct.dto.ProductDto;
import com.example.crudproduct.entity.Product;
import com.example.crudproduct.mapper.ProductMapper;

import java.util.List;

public class ProductMapperImpl implements ProductMapper {
    @Override
    public Product dtoEntity(ProductDto productDto) {
        return new Product();
    }

    @Override
    public ProductDto entityDto(Product product) {
        return new ProductDto();
    }

//    @Override
//    public List<ProductDto> entityToDto(List<Product> product) {
//        return null;
//    }
//
//    @Override
//    public List<Product> entityToEntity(List<ProductDto> productDto) {
//        return null;
//    }
}
