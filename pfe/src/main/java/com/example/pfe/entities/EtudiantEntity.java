package com.example.pfe.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "etudiants")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EtudiantEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable=false, length=50)
    private String nom;

    @Column(nullable=false, length=50)
    private String prenom;

    private String email;

    private String phone;

    private String cne;

//    @JsonIgnore
//    @OneToMany(mappedBy="etudiant", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
//    private List<AbsenceEntity> absences;

//    @JsonIgnore
//    @OneToMany(mappedBy="etudiant", fetch = FetchType.LAZY, cascade=CascadeType.REMOVE)
//    private List<MessageEntity> messages;



}
