package com.example.pfe.controller;

import com.example.pfe.dto.AbsenceDto;
import com.example.pfe.dto.UserDto;
import com.example.pfe.services.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/absence")
public class AbsenceController {

   @Autowired
   AbsenceService absenceService;

    //------- All  : -------------------------------------------------------------------

    @GetMapping("/all")

    public ResponseEntity<List<AbsenceDto>> getAllUsers(Principal principal){
        System.out.printf(" principal.getName() " +  principal.getName()+"\n");

        List<AbsenceDto> userDto = absenceService.getall();

        return ResponseEntity.ok(userDto);
    }
    //------- Add  : ------------------------------------------------------------------

    @PostMapping("/add")

    public ResponseEntity<AbsenceDto> addUser(@RequestBody AbsenceDto absDto )  {


        AbsenceDto newuser = absenceService.add(absDto);

        return new ResponseEntity<AbsenceDto>(newuser, HttpStatus.CREATED);

    }
    //------- Delete  : --------------------------------------------------------------

    @DeleteMapping("/delete/{date}/{id}")

    public ResponseEntity<String> delete(@PathVariable String date, @PathVariable long id){


        absenceService.delete(date,id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}