package com.negocioBimba.negocioBimba.controller;

import com.negocioBimba.negocioBimba.DTO.OrderDto;
import com.negocioBimba.negocioBimba.domain.Order;
import com.negocioBimba.negocioBimba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity<?> saveOrder(@RequestBody OrderDto orderDto) {
        return orderService.create(orderDto);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<?> getAllorders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return orderService.deleteOrder(id);
    }

}
