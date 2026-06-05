package com.fpoly.springboot.controller;

import com.fpoly.springboot.model.Product;
import com.fpoly.springboot.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(
            ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(
            @PathVariable Long id) {

        return productService
                .getProductById(id)
                .orElse(null);
    }

    @PostMapping
    public Product addProduct(
            @RequestBody Product product) {

        return productService.addProduct(
                product
        );
    }

    @PutMapping("/{id}")
    public Product updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {

        return productService.updateProduct(
                id,
                product
        );
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(
            @PathVariable Long id) {

        boolean deleted =
                productService.deleteProduct(id);

        if (deleted) {
            return "Xoa thanh cong";
        }

        return "Khong tim thay san pham";
    }
}