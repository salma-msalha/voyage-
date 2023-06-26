package com.example.voyage.entities;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Administrateur {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String CIN;
    private String Nom;
    private String Prn;


    @OneToMany(mappedBy = "Admin")
    private List<Client> Clients;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_idCA")
    private Compte Compte;

    @OneToMany(mappedBy = "Admin")
    private List<Reservation> Reservations;
    @OneToMany(mappedBy = "Admin")
    private List<Pack> Packs;


}
