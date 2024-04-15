package com.negocioBimba.negocioBimba.service.impl;

import com.negocioBimba.negocioBimba.DTO.OrderDto;
import com.negocioBimba.negocioBimba.converters.OrderCoverter;
import com.negocioBimba.negocioBimba.model.Order;
import com.negocioBimba.negocioBimba.repository.OrderRepository;
import com.negocioBimba.negocioBimba.service.OrderService;
import com.negocioBimba.negocioBimba.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderCoverter orderCoverter;

    @Override
    public ResponseEntity<?> create(OrderDto orderDto) {
       Order orderEntity = orderRepository.save(orderCoverter.toEntity(orderDto));
       return new ResponseEntity<>(Message.builder()
               .message("Product created")
               .object(orderCoverter.toDto(orderEntity))
               .build()
               , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getOrderById(Integer id) {
        OrderDto orderDto = orderCoverter.toDto(orderRepository.findById(id).orElse(null));
        if (orderDto == null)
            return new ResponseEntity<>(Message.builder()
                    .object(null)
                    .message("Order not found")
                    .build()
                    ,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<?> getAllOrders() {
        List<OrderDto> listDto = orderCoverter.toDto(orderRepository.findAll());
        return new ResponseEntity<>(listDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteOrder(Integer id) {
        orderRepository.deleteById(id);
        return new ResponseEntity<>(Message.builder()
                .message("Order deleted")
                .build()
                ,HttpStatus.NO_CONTENT);
    }
}
