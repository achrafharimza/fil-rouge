package com.example.pfe.repositories;


import com.example.pfe.entities.AnnonceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<AnnonceEntity,Long> {
    AnnonceEntity findById(long id);

}