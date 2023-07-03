package com.example.Entités;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false)
    private String ville;

    @Column(nullable = false)
    private String password;

    // Constructeurs, getters, setters, etc.

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email, String ville, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.ville = ville;
        this.password = password;
    }

    // Getters et setters

    // ...
}
