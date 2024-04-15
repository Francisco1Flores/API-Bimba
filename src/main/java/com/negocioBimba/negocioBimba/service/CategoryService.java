package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.DTO.CategoryDto;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    ResponseEntity<?> save(CategoryDto categoryDto) throws Exception;
    ResponseEntity<?> getById(Integer id);
    ResponseEntity<?> getAll();
    ResponseEntity<?> delete(Integer id);
}
