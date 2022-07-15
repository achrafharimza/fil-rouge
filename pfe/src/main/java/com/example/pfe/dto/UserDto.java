package com.example.pfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private long id;
    private String nom;
    private String prenom;
    private Boolean admin=false;
    private String email;
    private String password;


}
