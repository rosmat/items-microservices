package com.example.itemservice.service;

import com.example.itemservice.dto.APIResponseDto;
import com.example.itemservice.dto.ItemDto;
import com.example.itemservice.entity.Item;
import com.example.itemservice.mapper.ItemMapper;
import com.example.itemservice.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryAPIClient categoryAPIClient;

    @Override
    @CachePut(cacheNames = "itemsById", key = "#result.id")
    public ItemDto save(ItemDto itemDto) {
        var item = ItemMapper.mapToItem(itemDto);
        var savedItem = itemRepository.save(item);
        return ItemMapper.mapToItemDto(savedItem);
    }

    @Override
    public List<ItemDto> save(List<ItemDto> itemDtos) {
        var items = itemDtos.stream().map(ItemMapper::mapToItem).toList();
        var savedItems = itemRepository.saveAll(items);
        return savedItems.stream().map(ItemMapper::mapToItemDto).toList();
    }

    @Override
    @Cacheable(cacheNames = "itemsById")
    public APIResponseDto getItemById(Long id) {
        var item = itemRepository.findById(id).orElseThrow();
        var category = categoryAPIClient.getCategory(item.getCategoryCode());

        return new APIResponseDto(ItemMapper.mapToItemDto(item), category);
    }

    @Override
    @Cacheable(cacheNames = "itemsByFilter")
    public Page<ItemDto> getItemByFilter(Long itemId, String name, Long count, Pageable pageable) {
        Specification<Item> spec = Specification.where(ItemRepository.Specs.byId(itemId))
                .and(ItemRepository.Specs.byName(name))
                .and(ItemRepository.Specs.byCount(count));

        var items = itemRepository.findAll(spec, pageable);

        return items.map(ItemMapper::mapToItemDto);
    }

    @Override
    @Cacheable(cacheNames = "allItems")
    public Page<ItemDto> getAllItems(Pageable pageable) {
        var items = itemRepository.findAll(pageable);
        return items.map(ItemMapper::mapToItemDto);
    }

    @Override
    @CacheEvict(cacheNames = "itemsById")
    public void delete(long itemId) {
        itemRepository.deleteById(itemId);
    }
}
