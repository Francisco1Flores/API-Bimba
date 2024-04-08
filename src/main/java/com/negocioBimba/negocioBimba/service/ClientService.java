package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.DTO.ClientDto;
import com.negocioBimba.negocioBimba.domain.Client;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    ResponseEntity<?> saveClient(ClientDto clientDto);
    ResponseEntity<?> getClientById(Integer id);
    ResponseEntity<?> getAllClients();
    ResponseEntity<?> deleteClient(Integer id);
    ResponseEntity<?> updateCLient(Integer id, ClientDto clientDto);
}
