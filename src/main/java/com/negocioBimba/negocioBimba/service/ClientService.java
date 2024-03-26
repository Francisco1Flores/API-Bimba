package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    void saveClient(Customer customer);
    Optional<Customer> getClientById(Integer id);
    List<Customer> getAllClients();
    void deleteClient(Integer id);
}
