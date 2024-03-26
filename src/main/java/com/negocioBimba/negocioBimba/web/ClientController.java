package com.negocioBimba.negocioBimba.web;


import com.negocioBimba.negocioBimba.domain.Customer;
import com.negocioBimba.negocioBimba.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public void saveClient(@RequestBody Customer customer) {
        clientService.saveClient(customer);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Customer> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
    public Optional<Customer> getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }
}
