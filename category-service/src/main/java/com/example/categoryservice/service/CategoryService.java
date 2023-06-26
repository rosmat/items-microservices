package com.example.categoryservice.service;

import com.example.categoryservice.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto getCategoryByCode(String code);

    List<CategoryDto> getAll();
}
