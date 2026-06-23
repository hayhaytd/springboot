package com.fpoly.springboot.controller;

import com.fpoly.springboot.model.ProductDb;
import com.fpoly.springboot.service.ProductDbService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
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
    public ProductDb addProduct(@Valid @RequestBody ProductDb product) {
        return productDbService.addProduct(product);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ProductDb>> getProductsPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        return ResponseEntity.ok( productDbService.getProductsWithPagination(page,size,sortBy));
    }

        @GetMapping("/count-by-category")
        public ResponseEntity<List<Object[]>> countByCategory() {

        return ResponseEntity.ok(
                productDbService.countProductsByCategory());
    }

}