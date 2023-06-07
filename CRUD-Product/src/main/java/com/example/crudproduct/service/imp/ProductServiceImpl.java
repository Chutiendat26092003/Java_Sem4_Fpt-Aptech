package com.example.crudproduct.service.imp;

import com.example.crudproduct.entity.Product;
import com.example.crudproduct.mapper.ProductMapper;
import com.example.crudproduct.mapper.imp.ProductMapperImpl;
import com.example.crudproduct.repository.ProductRepository;
import com.example.crudproduct.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepo;
    ProductMapper mapper = new ProductMapperImpl();

//    @Override
//    public List<Product> getListProduct() {
//        return productRepo.findall().stream().map(mapper :: entityToDto)
//                .collect(Collectors.toList());
//    }

}
