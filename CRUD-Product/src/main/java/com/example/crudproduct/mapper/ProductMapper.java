package com.example.crudproduct.mapper;

import com.example.crudproduct.dto.ProductDto;
import com.example.crudproduct.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    // 2 function : convert dto -> entity, entity -> dto
    Product dtoEntity(ProductDto productDto);
    ProductDto entityDto(Product product);
    List<ProductDto> entityToDto(List<Product> product);
    List<Product> entityToEntity(List<ProductDto> productDto);
}
