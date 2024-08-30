package com.negocioBimba.negocioBimba.converters;

import com.negocioBimba.negocioBimba.DTO.CategoryDto;
import com.negocioBimba.negocioBimba.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConverter implements Converter<CategoryDto, Category>{

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryDto toDto(Category entity) {
        if (entity == null) {
            return null;
        }
        return new CategoryDto(entity.getCategoryId(), entity.getName(), entity.getSupCategory());
    }

    @Override
    public Category toEntity(CategoryDto dto) {
        if (dto == null) {
            return null;
        }
        return new Category(dto.getCategoryId(),dto.getName(),dto.getSupCategoryId());
    }

    @Override
    public List<CategoryDto> toDto(List<Category> entityList) {
        if (entityList == null) {
            return null;
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Category> toEntity(List<CategoryDto> dtoList) {
        if (dtoList == null) {
            return null;
        }
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
