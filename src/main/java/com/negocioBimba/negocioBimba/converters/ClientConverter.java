package com.negocioBimba.negocioBimba.converters;

import com.negocioBimba.negocioBimba.DTO.ClientDto;
import com.negocioBimba.negocioBimba.domain.Client;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class ClientConverter implements Converter<ClientDto, Client>{

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ClientDto toDto(Client entity) {
        if (entity == null) return null;
        return modelMapper.map(entity, ClientDto.class);
    }

    @Override
    public Client toEntity(ClientDto dto) {
        if (dto == null) return null;
        return modelMapper.map(dto, Client.class);
    }

    @Override
    public List<ClientDto> toDto(List<Client> entityList) {
        if (entityList == null) return null;
        return entityList.stream().map(this::toDto).toList();
    }

    @Override
    public List<Client> toEntity(List<ClientDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::toEntity).toList();
    }
}
