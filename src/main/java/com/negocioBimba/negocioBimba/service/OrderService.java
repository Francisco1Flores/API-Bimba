package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.DTO.OrderDto;
import com.negocioBimba.negocioBimba.domain.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    ResponseEntity<?> create(OrderDto orderDto);
    ResponseEntity<?> getOrderById(Integer id);
    ResponseEntity<?> getAllOrders();
    ResponseEntity<?> deleteOrder(Integer id);
}
