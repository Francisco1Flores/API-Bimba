package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.DTO.ProductDto;
import com.negocioBimba.negocioBimba.domain.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ResponseEntity<?> create(ProductDto productDto) throws Exception;
    ResponseEntity<?> getProductById(Integer id);
    ResponseEntity<?> getAllProducts();
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<?> update(Integer id, ProductDto productDto) throws Exception;

}
