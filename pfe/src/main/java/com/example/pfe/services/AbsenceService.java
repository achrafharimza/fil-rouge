package com.example.pfe.services;

import com.example.pfe.dto.AbsenceDto;
import com.example.pfe.dto.EtudiantDto;

import java.util.List;

public interface AbsenceService {
    List<AbsenceDto> getall();
    AbsenceDto add(AbsenceDto user);
    AbsenceDto getone(String email);
    void delete(String date, long id);
}
