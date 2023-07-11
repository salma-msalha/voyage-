package com.example.voyage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Hotel {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_hotel;
    private String nom_h;
    private int etoile;
    private String site;
    private String email;
    private String tel;
    @OneToMany
    private List<Reservation> reservations;
}
