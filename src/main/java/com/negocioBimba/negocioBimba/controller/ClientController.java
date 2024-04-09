package com.negocioBimba.negocioBimba.controller;


import com.negocioBimba.negocioBimba.DTO.ClientDto;
import com.negocioBimba.negocioBimba.domain.Client;
import com.negocioBimba.negocioBimba.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ResponseEntity<?> saveClient(@RequestBody ClientDto clientDto) {
        return clientService.saveClient(clientDto);
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ResponseEntity<?> getAllClients() {
        return clientService.getAllClients();
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        return clientService.deleteClient(id);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteById(@PathVariable Integer id, @RequestBody ClientDto clientDto) {
        return clientService.updateCLient(id, clientDto);
    }
}
