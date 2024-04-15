package com.negocioBimba.negocioBimba.service.impl;

import com.negocioBimba.negocioBimba.DTO.CategoryDto;
import com.negocioBimba.negocioBimba.converters.CategoryConverter;
import com.negocioBimba.negocioBimba.model.Category;
import com.negocioBimba.negocioBimba.repository.CategoryRepository;
import com.negocioBimba.negocioBimba.service.CategoryService;
import com.negocioBimba.negocioBimba.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryConverter categoryConverter;

    @Override
    public ResponseEntity<?> save(CategoryDto categoryDto) throws Exception {
        Category category = categoryRepository.save(categoryConverter.toEntity(categoryDto));

        return new ResponseEntity<>(Message.builder()
                                            .message("Category created")
                                            .object(categoryConverter.toDto(category))
                                            .build()
                                    ,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getById(Integer id) {
        CategoryDto categoryDto = categoryConverter.toDto(categoryRepository.findById(id).orElse(null));

        if (categoryDto == null) {
            return new ResponseEntity<>(Message.builder()
                    .object(null)
                    .message("Category not found")
                    .build()
                    ,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAll() {
        List<CategoryDto> categoryDtoList = categoryConverter.toDto(categoryRepository.findAll());
        return new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        return new ResponseEntity<>(Message.builder()
                .object(null)
                .message("Category deleted")
                ,HttpStatus.NO_CONTENT);
    }

}
