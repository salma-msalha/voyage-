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
public class Vol {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int NVol;
    private Date date_achat;
    private Date arrivée;
    private Date dateDepart;
    //private Heure h_arrivée ;
    //private Heure h_depart;
    private String type;
    private int N_place;
    private Double prix_achat;
    private Double prix_vente;
}
