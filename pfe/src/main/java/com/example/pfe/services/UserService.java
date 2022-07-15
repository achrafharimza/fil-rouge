package com.example.pfe.services;

import com.example.pfe.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<UserDto> getUsers();
    UserDto addUser(UserDto user);
    UserDto getUser(String email);
    void delete(long id);
}
