package com.negocioBimba.negocioBimba.repository;

import com.negocioBimba.negocioBimba.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
