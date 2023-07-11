package com.example.voyage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Pack {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private Date date_debut ;
    private Date date_fin;
    private String Description;
    private Double prxMini;
    @ManyToOne
    private Vol vol;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private Service serv;
    @ManyToMany(mappedBy = "packs")
    private Set<Visiteur> visiteurs= new HashSet<>();
    @ManyToOne
    private Administrateur Admin;
}
