package com.example.voyage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data@NoArgsConstructor@AllArgsConstructor@ToString
@Entity
@Table
public class Chambre {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_chambre;
    private int num;
    private Date date_debut;
    private Date date_fin;
    private Double prix_achat;
    private Double prix_vente;

    @OneToMany(mappedBy = "chamb")
    private List<Pack> packs;
    @ManyToOne
    private Hotel Hotel;
    @ManyToOne
    private Reservation Reservation ;
    @ManyToMany(mappedBy = "chambres")
    private Set<Visiteur> visiteurs= new HashSet<>();
}
