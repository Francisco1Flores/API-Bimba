package com.negocioBimba.negocioBimba.service;

import com.negocioBimba.negocioBimba.DTO.UserDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> saveUser(UserDto clientDto);
    ResponseEntity<?> getUserById(Integer id);
    ResponseEntity<?> getAllUsers();
    ResponseEntity<?> deleteUser(Integer id);
    ResponseEntity<?> updateUser(Integer id, UserDto clientDto);
}
