package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void saveOrder(Order order);
    Optional<Order> getOrderById(Integer id);
    List<Order> getAllOrders();
    void deleteOrder(Integer id);
}
