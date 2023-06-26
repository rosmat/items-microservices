package com.example.itemservice.service;

import com.example.itemservice.dto.APIResponseDto;
import com.example.itemservice.dto.ItemDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    ItemDto save(ItemDto itemDto);

    List<ItemDto> save(List<ItemDto> itemDtos);

    APIResponseDto getItemById(Long itemId);
    Page<ItemDto> getItemByFilter(Long itemId, String name, Long count, Pageable pageable);

    Page<ItemDto> getAllItems(Pageable pageable);

    void delete(long itemId);
}
