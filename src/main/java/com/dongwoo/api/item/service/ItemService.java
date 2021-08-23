package com.dongwoo.api.item.service;

import com.dongwoo.api.item.domain.Item;
import java.util.List;
import java.util.Optional;

public interface ItemService {

    List<Item> findAll();

    Optional<Item> findById(long id);

    void save(Item item);

    boolean existsById(long id);

    long count();

    void deleteById(long id);

    void deleteAll();
}
