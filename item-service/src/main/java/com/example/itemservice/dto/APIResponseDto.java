package com.example.itemservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIResponseDto {
    private ItemDto item;
    private CategoryDto category;
}
