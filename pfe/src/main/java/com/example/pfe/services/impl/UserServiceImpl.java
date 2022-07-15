package com.example.pfe.services.impl;

import com.example.pfe.dto.UserDto;
import com.example.pfe.dto.services.IMapClassWithDto;
import com.example.pfe.entities.EtudiantEntity;
import com.example.pfe.entities.UserEntity;
import com.example.pfe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.pfe.repositories.userRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    userRepository userRepository;
    @Autowired
    IMapClassWithDto<UserEntity, UserDto> userMapping;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserDto> getUsers() {
        List<UserEntity> users = userRepository.findAll();
        return userMapping.convertListToListDto(users,UserDto.class);
    }

    @Override
    public UserDto addUser(UserDto user) {
        String pass = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(pass);
        UserEntity userEntity = userMapping.convertToEntity(user, UserEntity.class);

        userEntity = userRepository.save(userEntity);

        return userMapping.convertToDto(userEntity, UserDto.class);
    }

    @Override
    public UserDto getUser(String email) {
        System.out.println("userDto.getEmail()\n");
        System.out.println(email);


        UserEntity currentUser = userRepository.findByEmail(email);

        return userMapping.convertToDto(currentUser, UserDto.class);
    }
    @Override
    public void delete(long id) {
        UserEntity user = userRepository.findById(id);

        if(user == null) throw new RuntimeException("user not found");

        userRepository.deleteById(id);

    }


    /////////////////////////////////////////jwt
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        System.out.println("login load");



        if(user == null) throw new UsernameNotFoundException(email);

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}