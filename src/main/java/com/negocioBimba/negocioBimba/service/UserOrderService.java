package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.DTO.UserOrderDto;
import org.springframework.http.ResponseEntity;

public interface UserOrderService {
    ResponseEntity<?> create(UserOrderDto orderDto);
    ResponseEntity<?> getOrderById(Integer id);
    ResponseEntity<?> getAllOrders();
    ResponseEntity<?> deleteOrder(Integer id);
    ResponseEntity<?> updateOrder(Integer id);

}
