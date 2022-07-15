package com.example.pfe.repositories;

import com.example.pfe.entities.AbsenceEntity;
import com.example.pfe.entities.MessageEntity;
import com.example.pfe.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<MessageEntity,Long> {
    MessageEntity findById(long id);
    List<MessageEntity> findByEtudiant_Email(String id);

}