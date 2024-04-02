package com.negocioBimba.negocioBimba.controller;


import com.negocioBimba.negocioBimba.DTO.ProductDto;
import com.negocioBimba.negocioBimba.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody ProductDto product) throws Exception {
        return productService.create(product);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> read(@PathVariable("id") Integer id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<?> readAll() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
         return productService.delete(id);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody ProductDto productDto) throws Exception {
        return productService.update(id, productDto);
    }

}
