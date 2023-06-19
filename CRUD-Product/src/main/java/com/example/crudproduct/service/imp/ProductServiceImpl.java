package com.example.crudproduct.service.imp;

import com.example.crudproduct.dto.ProductDto;
import com.example.crudproduct.entity.Product;
import com.example.crudproduct.mapper.ProductMapper;
import com.example.crudproduct.mapper.imp.ProductMapperImpl;
import com.example.crudproduct.repository.ProductRepository;
import com.example.crudproduct.repository.imp.ProductRepositoryImp;
import com.example.crudproduct.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepo = new ProductRepositoryImp();
    ProductMapper mapper = new ProductMapperImpl();

    @Override
    public List<ProductDto> getListProduct(){
        //productRepo.findall().stream().map(p -> productMap.entityToDto(p)).collect(Collectors.toList());
        return productRepo.gets().stream().map(mapper :: entityDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public List<Product> getListProduct() {
//        return productRepo.findall().stream().map(mapper :: entityToDto)
//                .collect(Collectors.toList());
//    }

}
