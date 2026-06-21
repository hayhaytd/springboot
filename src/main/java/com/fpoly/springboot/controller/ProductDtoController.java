package com.fpoly.springboot.controller;

import com.fpoly.springboot.dto.ProductDTO;
import com.fpoly.springboot.service.ProductBackupService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dto/products")
public class ProductDtoController {

    private final ProductBackupService service;

    public ProductDtoController(
            ProductBackupService service){

        this.service = service;
    }

    @GetMapping("/{id}")
    public ProductDTO getDto(
            @PathVariable Long id){

        return service.getProductDtoInfo(id);
    }

    
}
