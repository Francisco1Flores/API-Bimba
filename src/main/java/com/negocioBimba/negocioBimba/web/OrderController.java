package com.negocioBimba.negocioBimba.web;

import com.negocioBimba.negocioBimba.domain.Order;
import com.negocioBimba.negocioBimba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public void saveOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getAllorders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public Optional<Order> getOrderById(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }

}
