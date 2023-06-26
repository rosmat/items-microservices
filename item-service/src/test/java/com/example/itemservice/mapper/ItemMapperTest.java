package com.example.itemservice.mapper;

import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.entity.Item;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ItemMapperTest {

    @Test
    void shouldMapToItemDto() {
        var item = new Item(1L, "T1", 12.34, 5L, "t 1", LocalDateTime.now(), "C1");
        var itemDto = ItemMapper.mapToItemDto(item);

        assertItemsEqual(itemDto, item);
    }

    @Test
    void shouldMapToItem() {
        var itemDto = new ItemDto(1L, "T1", 12.34, 5L, "t 1", LocalDateTime.now(), "C1");
        var item = ItemMapper.mapToItem(itemDto);

        assertItemsEqual(itemDto, item);
    }

    private static void assertItemsEqual(ItemDto itemDto, Item item) {
        assertEquals(item.getId(), itemDto.getId());
        assertEquals(item.getName(), itemDto.getName());
        assertEquals(item.getPrice(), itemDto.getPrice());
        assertEquals(item.getCount(), itemDto.getCount());
        assertEquals(item.getDescription(), itemDto.getDescription());
        assertEquals(item.getReleased(), itemDto.getReleased());
        assertEquals(item.getCategoryCode(), itemDto.getCategoryCode());
    }
}
