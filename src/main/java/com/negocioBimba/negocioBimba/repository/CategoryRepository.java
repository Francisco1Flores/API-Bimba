package com.negocioBimba.negocioBimba.repository;

import com.negocioBimba.negocioBimba.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
