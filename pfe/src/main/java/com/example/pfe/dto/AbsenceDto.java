package com.example.pfe.dto;

import com.example.pfe.entities.AbsenceEntity;
import com.example.pfe.entities.EtudiantEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceDto {

    private long id;

    //@JsonFormat(pattern="yyyy-MM-dd")
    private String date;

    private String justification;

    private EtudiantEntity etudiantId;


}
