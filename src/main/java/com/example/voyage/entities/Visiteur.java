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
public class Visiteur {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    @ManyToMany
    private Set<Pack> packs= new HashSet<>();
    @ManyToMany
    private Set<Service> services= new HashSet<>();
    @ManyToMany
    private Set<Hotel> hotels= new HashSet<>();
    @ManyToMany
    private Set<Vol> vols= new HashSet<>();

}
