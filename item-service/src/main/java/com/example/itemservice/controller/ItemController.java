package com.example.itemservice.controller;

import com.example.itemservice.dto.APIResponseDto;
import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.entity.Item;
import com.example.itemservice.repository.ItemRepository;
import com.example.itemservice.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/items")
@AllArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        //TODO: validate category code
        var item = itemService.save(itemDto);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PostMapping("/multiple")
    public ResponseEntity<List<ItemDto>> createItems(@RequestBody List<ItemDto> itemDtos) {
        //TODO: validate category codes
        var items = itemService.save(itemDtos);
        return new ResponseEntity<>(items, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ItemDto>> getAllItems(Pageable pageable) {
        return new ResponseEntity<>(itemService.getAllItems(pageable), HttpStatus.OK);
    }

    @GetMapping("/withFilter")
    public ResponseEntity<Page<ItemDto>> getItemByFilter(@RequestParam(value = "itemId", required = false) Long itemId,
                                                  @RequestParam(value = "name", required = false) String name,
                                                  @RequestParam(value = "count", required = false) Long count, Pageable pageable) {
        var apiResponseDto = itemService.getItemByFilter(itemId, name, count, pageable);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getItemById(@RequestParam("id") Long itemId) {
        var apiResponseDto = itemService.getItemById(itemId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable("id") long itemId, @RequestBody ItemDto itemDto) {
        itemDto.setId(itemId);
        //TODO: validate category code
        var item = itemService.save(itemDto);
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable("id") long itemId) {
        itemService.delete(itemId);
    }
}
