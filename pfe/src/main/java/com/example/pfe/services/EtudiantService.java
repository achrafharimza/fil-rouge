package com.example.pfe.services;


import com.example.pfe.dto.EtudiantDto;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface EtudiantService {

    List<EtudiantDto> getall();
    EtudiantDto add(EtudiantDto user);
    EtudiantDto getone(String email);
    void delete(long id);
    void test(String date) throws ParseException;
    List<EtudiantDto> getByDate(String date) throws ParseException;


}
