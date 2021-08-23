package com.dongwoo.api.order.service;

import com.dongwoo.api.order.domain.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> findAll();

    Optional<Order> findById(long id);

    void save(Order item);

    boolean existsById(long id);

    long count();

    void deleteById(long id);

}
