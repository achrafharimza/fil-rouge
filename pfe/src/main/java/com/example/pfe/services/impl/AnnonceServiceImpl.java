package com.example.pfe.services.impl;

import com.example.pfe.dto.AbsenceDto;
import com.example.pfe.dto.AnnonceDto;
import com.example.pfe.dto.EtudiantDto;
import com.example.pfe.dto.services.IMapClassWithDto;
import com.example.pfe.entities.AbsenceEntity;
import com.example.pfe.entities.AnnonceEntity;
import com.example.pfe.entities.EtudiantEntity;
import com.example.pfe.entities.MessageEntity;
import com.example.pfe.repositories.AbsenceRepository;
import com.example.pfe.repositories.AnnonceRepository;
import com.example.pfe.services.AbsenceService;
import com.example.pfe.services.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService {

    @Autowired
    AnnonceRepository annonceRepository;
    @Autowired
    IMapClassWithDto<AnnonceEntity, AnnonceDto> mapping;


    @Override
    public List<AnnonceDto> getall() {
        List<AnnonceEntity> annoncesEntity = annonceRepository.findAll();
;
        List<AnnonceDto> annonestDto = mapping.convertListToListDto(annoncesEntity,AnnonceDto.class);

        return annonestDto;
    }
    @Override
    public void delete(long id) {
        AnnonceEntity msg = annonceRepository.findById(id);

        if(msg == null) throw new RuntimeException("annoces not found");

        annonceRepository.deleteById(id);
    }
    @Override
    public AnnonceDto add(AnnonceDto annonce) {
        AnnonceEntity annonceEntity = mapping.convertToEntity(annonce, AnnonceEntity.class);

        annonceEntity = annonceRepository.save(annonceEntity);

        return mapping.convertToDto(annonceEntity, AnnonceDto.class);
    }

    @Override
    public AnnonceDto getone(String email) {
        return null;
    }


}

