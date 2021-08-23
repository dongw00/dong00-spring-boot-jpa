package com.dongwoo.api.item.repository;

import com.dongwoo.api.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
