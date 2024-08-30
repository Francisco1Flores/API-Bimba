package com.negocioBimba.negocioBimba.controller;

import com.negocioBimba.negocioBimba.DTO.UserOrderDto;
import com.negocioBimba.negocioBimba.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    UserOrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity<?> saveOrder(@RequestBody UserOrderDto orderDto) {
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
