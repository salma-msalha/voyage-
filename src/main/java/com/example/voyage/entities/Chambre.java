package com.example.voyage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
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
}
