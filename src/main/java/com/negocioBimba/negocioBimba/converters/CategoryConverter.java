package com.negocioBimba.negocioBimba.converters;

import com.negocioBimba.negocioBimba.DTO.CategoryDto;
import com.negocioBimba.negocioBimba.model.Category;
import com.negocioBimba.negocioBimba.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryConverter implements Converter<CategoryDto, Category>{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public CategoryDto toDto(Category entity) {
        if (entity == null) return null;

        CategoryDto dto = modelMapper.map(entity, CategoryDto.class);

        if (entity.getSupCategory() == 0) {
            dto.setSupCategory("");
            return dto;
        }

        dto.setSupCategory(categoryRepository.findById(entity.getSupCategory()).get().getName());

        return dto;
    }

    @Override
    public Category toEntity(CategoryDto dto) {
        if (dto == null) return null;

        Category entity = new Category();
        entity.setName(dto.getName());

        if (dto.getSupCategory() == null) {
            entity.setSupCategory(0);
            return entity;
        }

        entity.setSupCategory(categoryRepository.findByName(dto.getSupCategory()).get().getCategoryId());

        return entity;
    }

    @Override
    public List<CategoryDto> toDto(List<Category> entityList) {
        if (entityList == null) return null;

        return entityList.stream().map(e -> toDto(e)).collect(Collectors.toList());
    }

    @Override
    public List<Category> toEntity(List<CategoryDto> dtoList) {
        if (dtoList == null) return null;

        return dtoList.stream().map(d -> toEntity(d)).collect(Collectors.toList());
    }
}
