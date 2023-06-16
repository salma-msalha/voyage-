package com.example.voyage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Compte {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String Pseudo;
    private String Mdp;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_idCC")
    private Client Client;
}
