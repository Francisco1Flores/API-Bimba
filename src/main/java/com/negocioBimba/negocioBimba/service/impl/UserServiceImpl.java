package com.negocioBimba.negocioBimba.service.impl;

import com.negocioBimba.negocioBimba.DTO.UserDto;
import com.negocioBimba.negocioBimba.converters.UserConverter;
import com.negocioBimba.negocioBimba.model.User;
import com.negocioBimba.negocioBimba.repository.UserRepository;
import com.negocioBimba.negocioBimba.service.UserService;
import com.negocioBimba.negocioBimba.utils.Message;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ResponseEntity<?> saveUser(UserDto userDto) {
        User user = userConverter.toEntity(userDto);
        user.setCreationDate(new Date());

        userDto = userConverter.toDto(userRepository.save(user));

        return new ResponseEntity<>(Message
                .builder()
                .message("User created")
                .object(userDto)
                .build(),
                HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null || user.getDeletionDate() != null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        UserDto userDto = userConverter.toDto(user);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllUsers() {
        List<User> usersList = userRepository.findAllByDeletionDateNull();
        List<UserDto> usersDto = userConverter.toDto(usersList);
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteUser(Integer id) {
        User deletedUser = userRepository.findById(id).orElse(null);
        if (deletedUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        deletedUser.setDeletionDate(new Date());
        userRepository.save(deletedUser);

        return new ResponseEntity<>(Message.builder()
                .message("User deleted")
                .build()
                ,HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<?> updateUser(Integer id, UserDto userDto) {
        User existingUser = userRepository.findById(id).orElse(null);

        if (existingUser == null || existingUser.getDeletionDate() != null) {
            return saveUser(userDto);
        }

        userDto.setUserId(id);
        User updatedUser = userConverter.toEntity(userDto);
        updateEntity(updatedUser, existingUser);
        updatedUser = userRepository.save(existingUser);

        UserDto updatedUserDto = userConverter.toDto(updatedUser);

        return new ResponseEntity<>(Message.builder()
                .message("User updated")
                .object(updatedUserDto)
                .build()
                ,HttpStatus.OK);
    }

    private void updateEntity(User newUser, User oldUser) {
        var date = oldUser.getCreationDate();
        modelMapper.map(newUser, oldUser);
        oldUser.setCreationDate(date);
    }
}
