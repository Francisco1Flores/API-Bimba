package com.negocioBimba.negocioBimba.converters;

import com.negocioBimba.negocioBimba.DTO.ProductDto;
import com.negocioBimba.negocioBimba.domain.Product;
import com.negocioBimba.negocioBimba.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProductConverter implements Converter<ProductDto, Product>{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public ProductDto toDto(Product entity) {
        if (entity == null) return null;
        ProductDto productDto = modelMapper.map(entity, ProductDto.class);
        if (entity.getCategory() != null)
            productDto.setCategory(entity.getCategory().getName());
        else
            productDto.setCategory(null);
        return productDto;
    }

    @Override
    public Product toEntity(ProductDto dto) {
        Product product = modelMapper.map(dto, Product.class);
        product.setCategory(categoryRepository.findByName(dto.getCategory()).orElse(null));
        return product;
    }

    @Override
    public List<ProductDto> toDto(List<Product> entityList) {
        if (entityList == null) return null;
        return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
    }

    @Override
    public List<Product> toEntity(List<ProductDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
    }
}
