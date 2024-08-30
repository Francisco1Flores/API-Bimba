package com.negocioBimba.negocioBimba.converters;

import com.negocioBimba.negocioBimba.DTO.ProductDto;
import com.negocioBimba.negocioBimba.model.Category;
import com.negocioBimba.negocioBimba.model.Product;
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
        if (entity == null) {
            return null;
        }
        return new ProductDto(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getStock(),
                entity.getCategory().getCategoryId()
        );
    }

    @Override
    public Product toEntity(ProductDto dto) {
        if (dto == null) {
            return null;
        }
        Category category = categoryRepository.findById(dto.getCategory()).orElse(null);
        if (category == null) {
            category = categoryRepository.findById(0).orElse(null);
        }
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getPrice(),
                dto.getStock(),
                category
                );
    }

    @Override
    public List<ProductDto> toDto(List<Product> entityList) {
        if (entityList == null) return null;
        return entityList.stream().map(this::toDto).toList();
    }

    @Override
    public List<Product> toEntity(List<ProductDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::toEntity).toList();
    }
}
