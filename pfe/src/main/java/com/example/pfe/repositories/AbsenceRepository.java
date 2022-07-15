package com.example.pfe.repositories;

import com.example.pfe.entities.AbsenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<AbsenceEntity,Long> {
    List<AbsenceEntity> findByDateAndEtudiant_Id(String date, long id);
    AbsenceEntity findByDate(String date);

}
