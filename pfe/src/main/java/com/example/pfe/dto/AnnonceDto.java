package com.example.pfe.dto;

import com.example.pfe.entities.EtudiantEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnonceDto {
    private long id;

    private String titre;
    private String date;
    private String contenu;

    private String urgence;


}
