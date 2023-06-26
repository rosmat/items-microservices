package com.example.categoryservice.service;

import com.example.categoryservice.dto.CategoryDto;
import com.example.categoryservice.mapper.CategoryMapper;
import com.example.categoryservice.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    @Cacheable(cacheNames = "categoryByCode")
    public CategoryDto getCategoryByCode(String code) {
        var category = categoryRepository.findByCode(code);
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    @Cacheable(cacheNames = "allCategories")
    public List<CategoryDto> getAll() {
        var categories = categoryRepository.findAll();

        return categories.stream()
                .map(CategoryMapper::mapToCategoryDto)
                .collect(Collectors.toList());
    }
}
