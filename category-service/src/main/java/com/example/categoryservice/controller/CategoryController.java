package com.example.categoryservice.controller;

import com.example.categoryservice.dto.CategoryDto;
import com.example.categoryservice.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{code}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("code") String code) {
        var category = categoryService.getCategoryByCode(code);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
