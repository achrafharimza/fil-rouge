package com.example.pfe.repositories;

import com.example.pfe.entities.AbsenceEntity;
import com.example.pfe.entities.EtudiantEntity;
import com.example.pfe.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<EtudiantEntity,Long> {
//    @Query(value="select  e.id from etudiants e, absences a where e.id= a.etudiants_id and a.date=to_date(:date, 'yyyy-MM-dd') group by e.id order by e.id asc", nativeQuery=true)
@Query(value="select  e.id from etudiants e, absences a where e.id= a.etudiants_id and a.date=:date group by e.id order by e.id asc", nativeQuery=true)

List<Long> getEtdByAbsenceDate(String date);
}
