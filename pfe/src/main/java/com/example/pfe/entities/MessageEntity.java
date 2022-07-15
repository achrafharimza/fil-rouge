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
@Table(name = "messages")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageEntity implements Serializable  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String date;


    private String content;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="etudiants_id")
    private EtudiantEntity etudiant;


}
