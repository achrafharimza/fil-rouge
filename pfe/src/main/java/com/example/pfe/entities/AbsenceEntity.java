package com.example.pfe.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Data
@Entity
@Table(name = "absences")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AbsenceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//    @JsonFormat(pattern="yyyy-MM-dd")
    private String date;


    private String justification;

//    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="etudiants_id")
    private EtudiantEntity etudiant;


}
