package com.delivery.delivery_service.repository;

import com.delivery.delivery_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    // Найти все заказы конкретного пользователя
    List<Order> findByUserId(Long userId);
}