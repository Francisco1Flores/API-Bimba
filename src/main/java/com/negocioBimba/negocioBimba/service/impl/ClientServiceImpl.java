package com.negocioBimba.negocioBimba.service.impl;

import com.negocioBimba.negocioBimba.domain.Customer;
import com.negocioBimba.negocioBimba.repository.ClientRepository;
import com.negocioBimba.negocioBimba.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public void saveClient(Customer customer) {
        clientRepository.save(customer);
    }

    @Override
    public Optional<Customer> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Customer> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);

    }
}
