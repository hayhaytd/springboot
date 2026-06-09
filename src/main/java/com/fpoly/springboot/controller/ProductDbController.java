package com.fpoly.springboot.controller;

import com.fpoly.springboot.model.ProductDb;
import com.fpoly.springboot.service.ProductDbService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db/products")
public class ProductDbController {

    private final ProductDbService productDbService;

    public ProductDbController(ProductDbService productDbService) {
        this.productDbService = productDbService;
    }

    @GetMapping
    public List<ProductDb> getAllProducts() {
        return productDbService.getAllProducts();
    }

    @PostMapping
    public ProductDb addProduct(@RequestBody ProductDb product) {
        return productDbService.addProduct(product);
    }
}