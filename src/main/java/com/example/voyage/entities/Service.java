package com.example.voyage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Service {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String description ;
    private Double prixAchat;
    private Double prixVente ;
    private int qte;
    @OneToMany(mappedBy = "serv")
    private List<Pack> packs;
    @ManyToMany
    private Set<Reservation> reservations= new HashSet<>();
    @ManyToMany(mappedBy = "services")
    private Set<Visiteur> visiteurs= new HashSet<>();
}
