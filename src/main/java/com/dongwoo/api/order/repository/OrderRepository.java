package com.dongwoo.api.order.repository;

import com.dongwoo.api.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
