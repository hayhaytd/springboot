package com.fpoly.springboot.controller;

import com.fpoly.springboot.model.Product;
import org.springframework.web.bind.annotation.*;
import com.fpoly.springboot.dto.StatisticsResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<Product> productList = new ArrayList<>();

    public ProductController() {

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

    @GetMapping
    public List<Product> getAllProducts() {
        return productList;
    }

    @GetMapping("/{id}")
public Product getProductById(
        @PathVariable Long id) {

    for (Product product : productList) {

        if (product.getId().equals(id)) {
            return product;
        }

    }

    return null;
}

@PostMapping
public Product addProduct(
        @RequestBody Product product) {

    productList.add(product);

    return product;
}

@DeleteMapping("/{id}")
public String deleteProduct(
        @PathVariable Long id) {

    boolean removed =
            productList.removeIf(
                    p -> p.getId().equals(id)
            );

    if (removed) {
        return "Xoa thanh cong";
    }

    return "Khong tim thay san pham";
}

@PutMapping("/{id}")
public Product updateProduct(
        @PathVariable Long id,
        @RequestBody Product updatedProduct) {

    for (Product product : productList) {

        if (product.getId().equals(id)) {

            product.setName(
                    updatedProduct.getName()
            );

            product.setPrice(
                    updatedProduct.getPrice()
            );

            return product;
        }
    }

    return null;
}

@GetMapping("/top")
public List<Product> getTopProducts(
        @RequestParam(defaultValue = "5") int n) {

    return productList.stream()
            .limit(n)
            .toList();
}

@GetMapping("/statistics")
public StatisticsResponse getStatistics() {

    int total = productList.size();

    double average = productList.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0);

    double max = productList.stream()
            .mapToDouble(Product::getPrice)
            .max()
            .orElse(0);

    double min = productList.stream()
            .mapToDouble(Product::getPrice)
            .min()
            .orElse(0);

    return new StatisticsResponse(
            total,
            average,
            max,
            min
    );
}

}