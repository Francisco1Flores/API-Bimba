package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.DTO.ProductDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> create(ProductDto productDto) throws Exception;
    ResponseEntity<?> getProductById(Integer id);
    ResponseEntity<?> getAllProducts();
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<?> update(Integer id, ProductDto productDto) throws Exception;

}
