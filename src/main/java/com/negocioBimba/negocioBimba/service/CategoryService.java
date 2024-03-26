package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.DTO.CategoryDto;
import com.negocioBimba.negocioBimba.domain.Category;
import com.negocioBimba.negocioBimba.utils.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    ResponseEntity<?> save(CategoryDto categoryDto) throws Exception;
    ResponseEntity<?> getById(Integer id);
    ResponseEntity<?> getAll();
    ResponseEntity<?> delete(Integer id);
}
