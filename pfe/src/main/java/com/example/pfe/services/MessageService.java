package com.example.pfe.services;

import com.example.pfe.dto.AnnonceDto;
import com.example.pfe.dto.MessageDto;

import java.util.List;

public interface MessageService {
    List<MessageDto> getall();
    MessageDto add(MessageDto user);
    MessageDto getone(String email);
    void delete( long id);
}
