package com.negocioBimba.negocioBimba.repository;

import com.negocioBimba.negocioBimba.model.OrderProduct;
import com.negocioBimba.negocioBimba.model.embeddedIds.OrderProductId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductId> {}
