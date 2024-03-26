package com.negocioBimba.negocioBimba.web;


import com.negocioBimba.negocioBimba.DTO.CategoryDto;
import com.negocioBimba.negocioBimba.domain.Category;
import com.negocioBimba.negocioBimba.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoriaController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto) throws Exception {
        return categoryService.save(categoryDto);
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        return categoryService.getById(id);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCategories() {
        return categoryService.getAll();
    }

}
