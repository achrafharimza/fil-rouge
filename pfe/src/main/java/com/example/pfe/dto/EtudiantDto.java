package com.example.pfe.dto;

import com.example.pfe.entities.AbsenceEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtudiantDto {


    private long id;
    private String nom;
    private String prenom;
    private String phone;
    private String cne;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean isAbsent;

    private List<AbsenceEntity> absences;


}
