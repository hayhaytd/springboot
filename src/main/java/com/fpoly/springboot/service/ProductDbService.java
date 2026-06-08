package com.fpoly.springboot.service;

import com.fpoly.springboot.model.ProductDb;
import com.fpoly.springboot.repository.ProductDbRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDbService {

    private final ProductDbRepository productDbRepository;

    public ProductDbService(
            ProductDbRepository productDbRepository) {

        this.productDbRepository = productDbRepository;
    }

    public List<ProductDb> getAllProducts() {
        return productDbRepository.findAll();
    }

    public Optional<ProductDb> getProductById(Long id) {
        return productDbRepository.findById(id);
    }

    public ProductDb addProduct(ProductDb product) {
        return productDbRepository.save(product);
    }
}