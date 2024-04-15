package com.negocioBimba.negocioBimba.repository;


import com.negocioBimba.negocioBimba.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Product, Integer> {
}
