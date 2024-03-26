package com.negocioBimba.negocioBimba.service.impl;


import com.negocioBimba.negocioBimba.DTO.ProductDto;
import com.negocioBimba.negocioBimba.Exceptions.ErrorMessage;
import com.negocioBimba.negocioBimba.Exceptions.ProductNotFoundException;
import com.negocioBimba.negocioBimba.converters.ProductConverter;
import com.negocioBimba.negocioBimba.domain.Product;
import com.negocioBimba.negocioBimba.repository.ProductoRepository;
import com.negocioBimba.negocioBimba.service.ProductService;
import com.negocioBimba.negocioBimba.utils.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    ProductConverter productConverter;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public ResponseEntity<?> create(ProductDto productDto) throws Exception {
        Product product = productoRepository.save(productConverter.toEntity(productDto));
        return new ResponseEntity<>(Message.builder()
                                            .message("Product created")
                                            .object(productConverter.toDto(product))
                                            .build()
                                    ,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getProductById(Integer id) {
        ProductDto productDto = productConverter.toDto(productoRepository.findById(id).orElse(null));
        if (productDto == null) {
            return new ResponseEntity<>(Message.builder()
                                                .object(null)
                                                .message("Product not found")
                                                .build()
                                        ,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(Message.builder()
                                            .object(productDto)
                                            .message("Product found")
                                            .build()
                                    ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllProducts() {
        List<ProductDto> listDto = productConverter.toDto(productoRepository.findAll());
        return new ResponseEntity<>(Message.builder()
                                            .object(listDto)
                                            .message("")
                                            .build()
                                    ,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        productoRepository.deleteById(id);
        return new ResponseEntity<>(Message.builder()
                                            .message("Product deleted")
                                            .build()
                                    ,HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<?> update(Integer id, ProductDto productDto) {
        productDto.setId(id);

        Product existingProduct = productoRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            Product newProduct = productoRepository.save(productConverter.toEntity(productDto));
            return new ResponseEntity<>(Message.builder()
                    .message("Product created")
                    .object(productConverter.toDto(newProduct)).build()
                    ,HttpStatus.CREATED);

        }

        Product updateProduct = productConverter.toEntity(productDto);

        modelMapper.map(updateProduct, existingProduct);

        productoRepository.save(existingProduct);

        return new ResponseEntity<>(Message.builder()
                                            .message("Product updated")
                                            .object(productConverter.toDto(existingProduct)).build()
                                    ,HttpStatus.OK);
    }
}
