package com.negocioBimba.negocioBimba.converters;

import com.negocioBimba.negocioBimba.DTO.OrderDto;
import com.negocioBimba.negocioBimba.DTO.OrderProductDto;
import com.negocioBimba.negocioBimba.model.CustomerOrder;
import com.negocioBimba.negocioBimba.model.OrderProduct;
import com.negocioBimba.negocioBimba.model.embeddedIds.OrderProductId;
import com.negocioBimba.negocioBimba.repository.UserRepository;
import com.negocioBimba.negocioBimba.repository.OrderProductRepository;
import com.negocioBimba.negocioBimba.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderConverter implements Converter<OrderDto, CustomerOrder> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductoRepository productRepository;

    @Autowired
    UserRepository clientRepository;

    @Autowired
    OrderProductRepository orderProductRepository;

    @Override
    public OrderDto toDto(CustomerOrder entity) {
        if (entity == null)
            return null;
        Set<OrderProductDto> productsDtos = entity.getProducts().stream()
                .map((p) -> new OrderProductDto(p.getProduct().getId(), p.getQuantity()))
                .collect(Collectors.toSet());

        return OrderDto.builder().
                id(entity.getId())
                .client(entity.getUser().getUserId())
                .stateOfPay(entity.getStateOfPay())
                .date(entity.getDate())
                .products(productsDtos)
                .build();
    }

    @Override
    public CustomerOrder toEntity(OrderDto dto) {
        if (dto == null) {
            return null;
        }

        Set<OrderProduct> products = new HashSet<>();
        CustomerOrder entity = new CustomerOrder();

        for (OrderProductDto product : dto.getProducts()) {
            OrderProductId orderProductId = new OrderProductId(dto.getId(), product.getProduct());
            products.add(orderProductRepository.findById(orderProductId).orElse(null));
        }

        entity.setId(dto.getId());
        entity.setDate(dto.getDate());
        entity.setStateOfPay(dto.getStateOfPay());
        entity.setProducts(products);
        entity.setUser(clientRepository.findById(dto.getClient()).orElse(null));
        return entity;
    }

    @Override
    public List<OrderDto> toDto(List<CustomerOrder> entityList) {
        if (entityList == null)
            return null;
        return entityList.stream().map(this::toDto).toList();
    }

    @Override
    public List<CustomerOrder> toEntity(List<OrderDto> dtoList) {
        if (dtoList == null)
            return null;
        return dtoList.stream().map(this::toEntity).toList();
    }
}
