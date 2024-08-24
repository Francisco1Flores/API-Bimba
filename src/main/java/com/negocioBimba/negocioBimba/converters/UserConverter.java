package com.negocioBimba.negocioBimba.converters;

import com.negocioBimba.negocioBimba.DTO.UserDto;
import com.negocioBimba.negocioBimba.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserConverter implements Converter<UserDto, User>{

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UserDto toDto(User entity) {
        if (entity == null) return null;
        return modelMapper.map(entity, UserDto.class);
    }

    @Override
    public User toEntity(UserDto dto) {
        if (dto == null) return null;
        return modelMapper.map(dto, User.class);
    }

    @Override
    public List<UserDto> toDto(List<User> entityList) {
        if (entityList == null) {
            return null;
        }
        //filter(d -> d.getDeletionDate() == null)
        return entityList.stream().map(this::toDto).toList();
    }

    @Override
    public List<User> toEntity(List<UserDto> dtoList) {
        if (dtoList == null) return null;
        return dtoList.stream().map(this::toEntity).toList();
    }
}
