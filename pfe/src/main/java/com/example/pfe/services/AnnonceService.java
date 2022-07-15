package com.example.pfe.services;

import com.example.pfe.dto.AbsenceDto;
import com.example.pfe.dto.AnnonceDto;

import java.util.List;

public interface AnnonceService {
    List<AnnonceDto> getall();
    AnnonceDto add(AnnonceDto user);
    AnnonceDto getone(String email);
    void delete(long id);
}
