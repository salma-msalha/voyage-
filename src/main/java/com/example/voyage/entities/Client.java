package com.example.voyage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data@NoArgsConstructor@AllArgsConstructor@ToString
@Entity
@Table
public class Client {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  Id;
    private String nom  ;
    private String prenom ;
    private String N_Cin ;
    private String adresse;
    private String N_passeport;
    private String tele;
    @ManyToOne
    private Administrateur Admin;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_idCC")
    private Compte Compte;
    @OneToMany(mappedBy = "Client")
    private List<Reservation> Reservations;
}
