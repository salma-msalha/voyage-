package com.example.voyage.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Transport {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private Date date_depart;
    private Date dateFin;
    //private Heure Heure_depart;
    //private Heure Heure_arrivée;
    private int num;
    private String type;
    private int n_place;
    private Double prix_achat;
    private Double prix_vente;
}
