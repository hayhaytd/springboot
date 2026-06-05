package com.fpoly.springboot.repository;

import com.fpoly.springboot.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    public ProductRepository() {

        productList.add(
                new Product(
                        1L,
                        "Laptop Acer Nitro",
                        18500000.0
                )
        );

        productList.add(
                new Product(
                        2L,
                        "Chuot Logitech G102",
                        400000.0
                )
        );
    }

    public List<Product> findAll() {
        return productList;
    }

    public Optional<Product> findById(Long id) {

        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void save(Product product) {
        productList.add(product);
    }

    public boolean deleteById(Long id) {

        return productList.removeIf(
                p -> p.getId().equals(id)
        );
    }

    public Product update(Long id, Product newProduct) {

        for (Product product : productList) {

            if (product.getId().equals(id)) {

                product.setName(
                        newProduct.getName()
                );

                product.setPrice(
                        newProduct.getPrice()
                );

                return product;
            }
        }

        return null;
    }
}