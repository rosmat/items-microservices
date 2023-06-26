package com.example.itemservice.service;

import com.example.itemservice.dto.CategoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081",value = "CATEGORY-SERVICE")
//@FeignClient(name = "CATEGORY-SERVICE")
public interface CategoryAPIClient {

    @GetMapping("api/categories/{code}")
    CategoryDto getCategory(@PathVariable("code") String categoryCode);
}
