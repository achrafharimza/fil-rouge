package com.example.pfe.services.impl;

import com.example.pfe.dto.AbsenceDto;
import com.example.pfe.dto.EtudiantDto;
import com.example.pfe.dto.MessageDto;
import com.example.pfe.dto.services.IMapClassWithDto;
import com.example.pfe.entities.*;
import com.example.pfe.repositories.AnnonceRepository;
import com.example.pfe.repositories.MessageRepository;
import com.example.pfe.repositories.userRepository;
import com.example.pfe.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    com.example.pfe.repositories.userRepository userRepository;
    @Autowired
    IMapClassWithDto<MessageEntity, MessageDto> mapping;

    @Override
    public List<MessageDto> getall() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String Principalemail = authentication.getName();
        UserEntity user = userRepository.findByEmail(Principalemail);
        Boolean isadmin=user.getAdmin();
        System.out.printf("isadmin = "+isadmin+"\n");
        List<MessageEntity> msg = messageRepository.findByEtudiant_Email(Principalemail);

        System.out.printf(" msgFindedmsgFindedmsgFindedmsgFinded  " +  msg.size()+"\n");


        List<MessageEntity> messagesent = messageRepository.findAll();
        List<EtudiantEntity> etudiantEntity=new ArrayList<>();
        for (MessageEntity item:messagesent){
            etudiantEntity.add(item.getEtudiant());
        }
        List<MessageDto> messgaesdto= mapping.convertListToListDto(messagesent,MessageDto.class);
        for(int i=0;i<messgaesdto.size();i++){

            messgaesdto.get(i).setEtudiantId(etudiantEntity.get(i));
        }
        return messgaesdto;
    }

    @Override
    public MessageDto add(MessageDto msgdto) {
        EtudiantEntity etudiant=msgdto.getEtudiantId();
        MessageEntity msgentity=mapping.convertToEntity(msgdto,MessageEntity.class);
        msgentity.setEtudiant(etudiant);
        msgentity=messageRepository.save(msgentity);
        return mapping.convertToDto(msgentity,MessageDto.class);



    }

    @Override
    public MessageDto getone(String email) {
        return null;
    }

    @Override
    public void delete(long id) {
        MessageEntity msg = messageRepository.findById(id);

        if(msg == null) throw new RuntimeException("message not found");

        messageRepository.deleteById(id);

    }
}
