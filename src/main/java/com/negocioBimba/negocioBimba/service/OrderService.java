package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.DTO.OrderDto;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<?> create(OrderDto orderDto);
    ResponseEntity<?> getOrderById(Integer id);
    ResponseEntity<?> getAllOrders();
    ResponseEntity<?> deleteOrder(Integer id);
}
