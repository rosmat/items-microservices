package com.example.itemservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ItemDto {
    private Long id;

    private String name;

    private Double price;

    private Long count;

    private String description;

    private LocalDateTime released;

    private String categoryCode;
}
