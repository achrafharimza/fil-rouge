package com.example.pfe.controller;

import com.example.pfe.dto.AnnonceDto;
import com.example.pfe.services.AnnonceService;
import com.example.pfe.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/annonce")
public class AnnonceController {

    @Autowired
    AnnonceService annonceService;

    //------- All  : -------------------------------------------------------------------

    @GetMapping("/all")

    public ResponseEntity<List<AnnonceDto>> getAll(){
        List<AnnonceDto> msgDto = annonceService.getall();
        return ResponseEntity.ok(msgDto);
    }
    //------- Add  : ------------------------------------------------------------------

    @PostMapping("/add")

    public ResponseEntity<AnnonceDto> add(@RequestBody AnnonceDto absDto )  {


        AnnonceDto newmsg = annonceService.add(absDto);

        return new ResponseEntity<AnnonceDto>(newmsg, HttpStatus.CREATED);

    }
    //------- Delete  : --------------------------------------------------------------

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> delete(@PathVariable long id){


        annonceService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}