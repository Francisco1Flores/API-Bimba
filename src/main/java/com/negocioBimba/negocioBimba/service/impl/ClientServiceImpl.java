package com.negocioBimba.negocioBimba.service.impl;

import com.negocioBimba.negocioBimba.DTO.ClientDto;
import com.negocioBimba.negocioBimba.converters.ClientConverter;
import com.negocioBimba.negocioBimba.domain.Client;
import com.negocioBimba.negocioBimba.domain.Product;
import com.negocioBimba.negocioBimba.repository.ClientRepository;
import com.negocioBimba.negocioBimba.service.ClientService;
import com.negocioBimba.negocioBimba.utils.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientConverter clientConverter;

    @Autowired
    ModelMapper modelMapper;

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
        Client client = clientRepository.findById(id).orElse(null);
        if (client == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(clientConverter.toDto(client), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllClients() {
        List<Client> clientsList = clientRepository.findAll();
        return new ResponseEntity<>(clientConverter.toDto(clientsList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteClient(Integer id) {
        clientRepository.deleteById(id);
        return new ResponseEntity<>(Message.builder()
                .message("Client deleted")
                .build()
                ,HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<?> updateCLient(Integer id, ClientDto clientDto) {

        clientDto.setClientId(id);
        Client existingClient = clientRepository.findById(id).orElse(null);

        if (existingClient == null) {
            Client newClient = clientRepository.save(clientConverter.toEntity(clientDto));
            return new ResponseEntity<>(Message.builder()
                    .message("Product created")
                    .object(clientConverter.toDto(newClient))
                    .build()
                    ,HttpStatus.CREATED);
        }

        Client updatedclient = clientConverter.toEntity(clientDto);

        modelMapper.map(updatedclient, existingClient);

        clientRepository.save(existingClient);

        return new ResponseEntity<>(Message.builder()
                .message("Product updated")
                .object(clientConverter.toDto(existingClient))
                .build()
                ,HttpStatus.OK);
    }
}
