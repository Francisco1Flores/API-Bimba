package com.negocioBimba.negocioBimba.converters;

import com.negocioBimba.negocioBimba.DTO.OrderDto;
import com.negocioBimba.negocioBimba.model.Order;
import com.negocioBimba.negocioBimba.model.Product;
import com.negocioBimba.negocioBimba.repository.ClientRepository;
import com.negocioBimba.negocioBimba.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderCoverter implements Converter<OrderDto, Order> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    ClientRepository clientRepository;

    @Override
    public OrderDto toDto(Order entity) {
        if (entity == null)
            return null;
        Set<Integer> productsIds = entity.getProducts().stream()
                .map(p -> p.getId()).collect(Collectors.toSet());

        return OrderDto.builder().
                id(entity.getId())
                .client(entity.getClient().getClientId())
                .state(entity.getState())
                .date(entity.getDate())
                .products(productsIds)
                .build();
    }

    @Override
    public Order toEntity(OrderDto dto) {
        if (dto == null)
            return null;
        Set<Product> products = new HashSet<>();
        Order entity = new Order();
        for (Integer productId : dto.getProducts()) {
            products.add(productoRepository.findById(productId).orElse(null));
        }
        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setState(dto.getState());
        entity.setProducts(products);
        entity.setClient(clientRepository.findById(dto.getClient()).orElse(null));
        return entity;
    }

    @Override
    public List<OrderDto> toDto(List<Order> entityList) {
        if (entityList == null)
            return null;
        return entityList.stream().map(this::toDto).toList();
    }

    @Override
    public List<Order> toEntity(List<OrderDto> dtoList) {
        if (dtoList == null)
            return null;
        return dtoList.stream().map(this::toEntity).toList();
    }
}
