package com.fpoly.springboot.service;

import com.fpoly.springboot.model.Product;
import com.fpoly.springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(
            ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product product) {

        if (product.getPrice() < 0) {

            throw new IllegalArgumentException(
                    "Gia khong duoc am"
            );
        }

        productRepository.save(product);

        return product;
    }

    public Product updateProduct(
            Long id,
            Product product) {

        return productRepository.update(
                id,
                product
        );
    }

    public boolean deleteProduct(Long id) {

        return productRepository.deleteById(id);
    }
}