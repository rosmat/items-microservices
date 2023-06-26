package com.example.categoryservice.mapper;

import com.example.categoryservice.dto.CategoryDto;
import com.example.categoryservice.entity.Category;

public class CategoryMapper {

    public static CategoryDto mapToCategoryDto(Category category) {
        if (category == null) {
            return null;
        }

        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getCode()
        );
    }

    public static Category mapToCategory(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }

        return new Category(
                categoryDto.getId(),
                categoryDto.getName(),
                categoryDto.getDescription(),
                categoryDto.getCode()
        );
    }
}
