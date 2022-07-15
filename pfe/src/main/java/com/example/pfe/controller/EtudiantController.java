package com.example.pfe.controller;


import com.example.pfe.dto.AbsenceDto;
import com.example.pfe.dto.EtudiantDto;
import com.example.pfe.dto.UserDto;
import com.example.pfe.services.EtudiantService;
import com.example.pfe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    EtudiantService etudiantService;

    //------- All users : -------------------------------------------------------------------

    @GetMapping("/all")

    public ResponseEntity<List<EtudiantDto>> getAllUsers(){
        List<EtudiantDto> userDto = etudiantService.getall();
        return ResponseEntity.ok(userDto);
    }
    @PostMapping("/add")

    public ResponseEntity<EtudiantDto> addUser(@RequestBody EtudiantDto etdDto )  {


        EtudiantDto newets = etudiantService.add(etdDto);

        return new ResponseEntity<EtudiantDto>(newets, HttpStatus.CREATED);

    }
    //------- All by absence date  : -------------------------------------------------------------------

    @GetMapping("/getByDate/{date}")

    public ResponseEntity<List<EtudiantDto>> getByDate(@PathVariable String date) throws ParseException {
        System.out.printf("date controller "+date+"\n");
        List<EtudiantDto> userDto = etudiantService.getByDate(date);
        return ResponseEntity.ok(userDto);
    }
}
