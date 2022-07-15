package com.example.pfe.controller;

import com.example.pfe.dto.MessageDto;
import com.example.pfe.services.AbsenceService;
import com.example.pfe.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    //------- All  : -------------------------------------------------------------------

    @GetMapping("/all")

    public ResponseEntity<List<MessageDto>> getAll(){
        List<MessageDto> msgDto = messageService.getall();
        return ResponseEntity.ok(msgDto);
    }
    //------- Add  : ------------------------------------------------------------------

    @PostMapping("/add")

    public ResponseEntity<MessageDto> add(@RequestBody MessageDto absDto )  {


        MessageDto newmsg = messageService.add(absDto);

        return new ResponseEntity<MessageDto>(newmsg, HttpStatus.CREATED);

    }
    //------- Delete  : --------------------------------------------------------------

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> delete( @PathVariable long id){


        messageService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}