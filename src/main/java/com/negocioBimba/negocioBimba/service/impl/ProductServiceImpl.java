package com.negocioBimba.negocioBimba.service.impl;


import com.negocioBimba.negocioBimba.DTO.ProductDto;
import com.negocioBimba.negocioBimba.converters.ProductConverter;
import com.negocioBimba.negocioBimba.model.Product;
import com.negocioBimba.negocioBimba.repository.ProductRepository;
import com.negocioBimba.negocioBimba.service.ProductService;
import com.negocioBimba.negocioBimba.utils.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductConverter productConverter;

    @Autowired
    ModelMapper modelMapper;

    
    @Override
    public ResponseEntity<?> create(ProductDto productDto) {

        Product product = productConverter.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        ProductDto savedProductDto = productConverter.toDto(savedProduct);

        return new ResponseEntity<>(Message.builder()
                                            .message("Product created")
                                            .object(savedProductDto)
                                            .build()
                                    ,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getProductById(Integer id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ProductDto productDto = productConverter.toDto(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productsDto = productConverter.toDto(products);
        return new ResponseEntity<>(productsDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        productRepository.deleteById(id);
        return new ResponseEntity<>(Message.builder()
                                            .message("Product deleted")
                                            .build()
                                    ,HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<?> update(Integer id, ProductDto productDto) {

        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct == null) {
            return create(productDto);
        }

        productDto.setId(id);
        Product updatedProduct = productConverter.toEntity(productDto);

        productDto = productConverter.toDto(productRepository.save(updatedProduct));

        return new ResponseEntity<>(Message.builder()
                .message("Product updated")
                .object(productDto)
                .build()
                ,HttpStatus.OK);
    }
}
