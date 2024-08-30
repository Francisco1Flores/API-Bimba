package com.negocioBimba.negocioBimba.service.impl;

import com.negocioBimba.negocioBimba.DTO.UserOrderDto;
import com.negocioBimba.negocioBimba.converters.OrderConverter;
import com.negocioBimba.negocioBimba.model.UserOrder;
import com.negocioBimba.negocioBimba.repository.UserOrderRepository;
import com.negocioBimba.negocioBimba.service.UserOrderService;
import com.negocioBimba.negocioBimba.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    UserOrderRepository orderRepository;

    @Autowired
    OrderConverter orderConverter;

    @Override
    public ResponseEntity<?> create(UserOrderDto orderDto) {
       UserOrder orderEntity = orderRepository.save(orderConverter.toEntity(orderDto));
       return new ResponseEntity<>(Message.builder()
               .message("Order created")
               .object(orderConverter.toDto(orderEntity))
               .build()
               , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getOrderById(Integer id) {
        UserOrderDto orderDto = orderConverter.toDto(orderRepository.findById(id).orElse(null));
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
        List<UserOrderDto> listDto = orderConverter.toDto(orderRepository.findAll());
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

    @Override
    public ResponseEntity<?> updateOrder(Integer id) {
        return null;
    }

}
