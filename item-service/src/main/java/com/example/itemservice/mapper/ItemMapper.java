package com.example.itemservice.mapper;

import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.entity.Item;

public class ItemMapper {
    public static ItemDto mapToItemDto(Item item) {
        if (item == null) {
            return null;
        }

        return new ItemDto(
                item.getId(),
                item.getName(),
                item.getPrice(),
                item.getCount(),
                item.getDescription(),
                item.getReleased(),
                item.getCategoryCode()
        );
    }

    public static Item mapToItem(ItemDto itemDto) {
        if (itemDto == null) {
            return null;
        }

        return new Item(
                itemDto.getId(),
                itemDto.getName(),
                itemDto.getPrice(),
                itemDto.getCount(),
                itemDto.getDescription(),
                itemDto.getReleased(),
                itemDto.getCategoryCode()
        );
    }
}
