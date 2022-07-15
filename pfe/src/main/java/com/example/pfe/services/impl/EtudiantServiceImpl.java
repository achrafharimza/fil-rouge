package com.example.pfe.services.impl;

import com.example.pfe.dto.EtudiantDto;
import com.example.pfe.dto.UserDto;
import com.example.pfe.dto.services.IMapClassWithDto;
import com.example.pfe.entities.EtudiantEntity;
import com.example.pfe.entities.UserEntity;
import com.example.pfe.repositories.userRepository;
import com.example.pfe.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    com.example.pfe.repositories.EtudiantRepository etudiantRepository;
    @Autowired
    IMapClassWithDto<EtudiantEntity, EtudiantDto> etudiantMapping;


    @Override
    public List<EtudiantDto> getall() {
        List<EtudiantEntity> usersEntity = etudiantRepository.findAll();
//        System.out.printf("usersEntityusersEntity = "+usersEntity.get(0).getAbsences().get(0).getJustification()+"\n");

        System.out.printf("usersEntityusersEntity = "+usersEntity.get(0)+"\n");
        List<EtudiantDto> etudiantDto = etudiantMapping.convertListToListDto(usersEntity,EtudiantDto.class);
//        System.out.printf("etudiantDtoetudiantDto ="+etudiantDto+"\n");

        return etudiantDto;
    }

    @Override
    public EtudiantDto add(EtudiantDto etd) {


        EtudiantEntity etdEntity = etudiantMapping.convertToEntity(etd, EtudiantEntity.class);

        etdEntity = etudiantRepository.save(etdEntity);

        return etudiantMapping.convertToDto(etdEntity, EtudiantDto.class);

    }

    @Override
    public EtudiantDto getone(String email) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void test(String date) throws ParseException {


        List<Long> etdAbs = etudiantRepository.getEtdByAbsenceDate(date);
        System.out.printf("etdAbs service "+ etdAbs+"\n");
//        for(int i=0;i<etdAbs.size();i++){
//            System.out.println(etdAbs.get(i));
//        }


        List<EtudiantEntity> users = etudiantRepository.findAll();
        List<EtudiantDto> usersDto =  etudiantMapping.convertListToListDto(users,EtudiantDto.class);
//       System.out.printf("alletdalletdalletdalletdalletd"+users+"\n");
        for(int i=0;i<etdAbs.size();i++){
            System.out.println(etdAbs.get(i));

            for(EtudiantDto abs : usersDto) {

                if (etdAbs.get(i)==abs.getId()){
                    abs.setIsAbsent(true);
                    System.out.println(abs.getId()+" "+ abs.getNom() +" "+ abs.getIsAbsent());
                }
            }



        }
//        for(EtudiantDto abs : usersDto) {
//
//            System.out.println(abs.getId()+" "+ abs.getNom() +" "+ abs.getIsAbsent());
//
//        }
    }

    @Override
    public List<EtudiantDto> getByDate(String date) throws ParseException {

        List<Long> etdAbs = etudiantRepository.getEtdByAbsenceDate(date);

        List<EtudiantEntity> users = etudiantRepository.findAll();
        List<EtudiantDto> usersDto =  etudiantMapping.convertListToListDto(users,EtudiantDto.class);
        System.out.printf("etdAbs.size() "+etdAbs.size()+etdAbs+"\n");
        if (etdAbs.size()==0){
            for(EtudiantDto abs : usersDto) {
                System.out.printf("forhhhhhh"+"\n");
                abs.setIsAbsent(false);
            }
        }
        else{
        for(int i=0;i<etdAbs.size();i++){
            System.out.printf("etdAbs.get(i) "+etdAbs.get(i));
            System.out.printf("\n"+"for111111111"+"\n");

            for(EtudiantDto abs : usersDto) {
//                abs.setIsAbsent(false);
                System.out.printf("for22222222222"+"\n");
                System.out.printf("(etdAbs.get(i)==abs.getId()"+etdAbs.get(i)+"="+abs.getId()+"\n");
//                System.out.printf("abs.getIsAbsentabs.getIsAbsentabs.getIsAbsent "+abs.getIsAbsent()+"\n");
                if (etdAbs.get(i)==abs.getId()){
                    abs.setIsAbsent(true);
                    System.out.printf("truetruetruetrue"+"\n");
                    break;
                }

                else if ((etdAbs.get(i)!=abs.getId()) && (abs.getIsAbsent()==null)) {
                    abs.setIsAbsent(false);
                    System.out.printf("falsefalsefalsefalsefalse"+"\n");

                }



            }
        } }
        return usersDto;
    }

}
