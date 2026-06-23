package com.fpoly.springboot.controller;

import com.fpoly.springboot.model.Category;
import com.fpoly.springboot.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return service.save(category);
    }
}