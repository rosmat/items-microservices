package com.example.itemservice.repository;

import com.example.itemservice.entity.Item;
import com.example.itemservice.entity.Item_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
    interface Specs {

        static Specification<Item> byId(Long itemId) {
            return (root, query, builder) -> {
                if (itemId == null) {
                    return builder.isTrue(builder.literal(true));
                }
                return builder.equal(root.get(Item_.ID), itemId);
            };
        }

        static Specification<Item> byName(String name) {
            return (root, query, builder) -> {
                if (name == null) {
                    return builder.isTrue(builder.literal(true));
                }
                return builder.equal(root.get(Item_.NAME), name);
            };
        }

        static Specification<Item> byCount(Long count) {
            return (root, query, builder) -> {
                if (count == null) {
                    return builder.isTrue(builder.literal(true));
                }
                return builder.equal(root.get(Item_.COUNT), count);
            };
        }
    }
}
