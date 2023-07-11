package com.example.voyage.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Vol {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private LocalTime Aheured;
    private LocalTime Aheurea;
    private LocalTime Rheured;
    private LocalTime Rheurea;
    private String typeA ;
    private String typeR ;
    private String avionA;
    private String avionR;
    private String villeA;
    private String villeR;
    private Date dateA;
    private Date dateR;
    private String durationA ;
    private String durationR ;
    /*private int NVol;
    private Date date_achat;
    private Date arrivée;
    private Date dateDepart;
    //private Heure h_arrivée ;
    //private Heure h_depart;
    private String type;
    private int N_place;
    private Double prix_achat;
    private Double prix_vente;*/
    @OneToMany(mappedBy = "vol")
    private List<Pack> packs;
    @OneToMany
    private List<Reservation> reservations;
    @ManyToMany(mappedBy = "vols")
    private Set<Visiteur> visiteurs= new HashSet<>();
}
