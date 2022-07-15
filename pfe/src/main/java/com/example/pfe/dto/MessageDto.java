package com.example.pfe.dto;

import com.example.pfe.entities.EtudiantEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private long id;


    private String date;

    private String content;

    private EtudiantEntity etudiantId;
}
