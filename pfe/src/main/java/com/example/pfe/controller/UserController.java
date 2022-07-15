package com.example.pfe.controller;

import com.example.pfe.dto.UserDto;
import com.example.pfe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;

    //------- All users : -------------------------------------------------------------------

    @GetMapping("/all")

    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDto = userService.getUsers();
        return ResponseEntity.ok(userDto);
    }

    //------- Add user : ------------------------------------------------------------------

    @PostMapping("/add")

    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto )  {


        UserDto newuser = userService.addUser(userDto);

        return new ResponseEntity<UserDto>(newuser, HttpStatus.CREATED);

    }
    //------- Delete  : --------------------------------------------------------------

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> delete(@PathVariable long id){
//        System.out.println("in contoller "+id);
//
//        userService.delete(id);
        String ocr="abc.jpg";
//        String[] newNameFile2=new String[2];
        String newNameFile2 =ocr.split("\\.")[1];

        System.out.printf("\n"+"newNameFile2 = "+newNameFile2+"\n");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
