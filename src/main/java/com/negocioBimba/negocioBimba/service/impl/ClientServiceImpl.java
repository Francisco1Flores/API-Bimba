package com.negocioBimba.negocioBimba.service.impl;

import com.negocioBimba.negocioBimba.DTO.ClientDto;
import com.negocioBimba.negocioBimba.converters.ClientConverter;
import com.negocioBimba.negocioBimba.domain.Client;
import com.negocioBimba.negocioBimba.repository.ClientRepository;
import com.negocioBimba.negocioBimba.service.ClientService;
import com.negocioBimba.negocioBimba.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientConverter clientConverter;

    @Override
    public ResponseEntity<?> saveClient(ClientDto clientDto) {
        Client client = clientRepository.save(clientConverter.toEntity(clientDto));

        return new ResponseEntity(Message
                .builder()
                .message("Clietn created")
                .object(clientConverter.toDto(client))
                .build(),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getClientById(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public ResponseEntity<?> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ResponseEntity<?> deleteClient(Integer id) {
        clientRepository.deleteById(id);

    }
}
