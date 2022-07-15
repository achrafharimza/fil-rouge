package com.example.pfe.services.impl;

import com.example.pfe.dto.AbsenceDto;
import com.example.pfe.dto.EtudiantDto;
import com.example.pfe.dto.UserDto;
import com.example.pfe.dto.services.IMapClassWithDto;
import com.example.pfe.entities.AbsenceEntity;
import com.example.pfe.entities.EtudiantEntity;
import com.example.pfe.entities.UserEntity;
import com.example.pfe.repositories.AbsenceRepository;
import com.example.pfe.services.AbsenceService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class AbsenceServiceImpl implements AbsenceService {
    @Autowired
    AbsenceRepository absenceRepository;
    @Autowired
    IMapClassWithDto<AbsenceEntity, AbsenceDto> mapping;
    @Autowired
    IMapClassWithDto<EtudiantEntity, EtudiantDto> mappingetd;
    @Override
    public List<AbsenceDto> getall() {
        List<AbsenceEntity> absensesEntity = absenceRepository.findAll();
        List<EtudiantEntity> etudiantEntity=new ArrayList<>();
        for (AbsenceEntity item:absensesEntity){
            etudiantEntity.add(item.getEtudiant());
        }
       List<AbsenceDto> absensesdto = mapping.convertListToListDto(absensesEntity,AbsenceDto.class);
        for(int i=0;i<absensesdto.size();i++){

            absensesdto.get(i).setEtudiantId(etudiantEntity.get(i));
        }


        return  absensesdto;

    }

    @Override
    public AbsenceDto add(AbsenceDto absence) {
        EtudiantEntity etudiant=absence.getEtudiantId();

        AbsenceEntity absenceEntity = mapping.convertToEntity(absence, AbsenceEntity.class);
        absenceEntity.setEtudiant(etudiant);

        absenceEntity = absenceRepository.save(absenceEntity);

        return mapping.convertToDto(absenceEntity, AbsenceDto.class);
    }

    @Override
    public AbsenceDto getone(String email) {
        return null;
    }

    @SneakyThrows
    @Override
    public void delete(String dateString, long id) {

//        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
//          Date  date2 = formatter2.parse(dateString);
        System.out.printf("\n"+"ididididid  = "+id+"\n");
        System.out.printf("\n"+"dateStringdateString  = "+dateString+"\n");


//        Date dateparseDate =DATE_FORMAT.parse(dateString);
//        System.out.printf("\n"+"dateparseDatedateparseDate  = "+dateparseDate+"\n");
//        AbsenceEntity user = absenceRepository.findByDate(dateString);
        List<AbsenceEntity> user = absenceRepository.findByDateAndEtudiant_Id(dateString, id);
        System.out.printf("user.size()user.size() " + user.size()+"\n");
        if (user.size() == 0) throw new RuntimeException("Absence not found");
        System.out.printf("\n"+"dateStringdateString  = "+user.get(0).getDate()+"\n");



        absenceRepository.deleteById(user.get(0).getId());
    }
}
