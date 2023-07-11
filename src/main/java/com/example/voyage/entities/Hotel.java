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

@Data@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Hotel {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_hotel;
    private String nom_h;
    private String desc;
    private String img;
    private Date checkin;
    private Date checkout;
    private int n_r;
    private int g_ad;
    private int g_ch;

    //private int etoile;
    //private String site;
    //private String email;
    //private String tel;
    //@OneToMany(mappedBy = "Hotel")
    //private List<Chambre> Chambres;
    @OneToMany(mappedBy = "hotel")
    private List<Pack> packs;
    @ManyToOne
    private Reservation Reservation ;
    @ManyToMany(mappedBy = "hotels")
    private Set<Visiteur> visiteurs= new HashSet<>();

   /* public Hotel(String titre, String description, String img, Date checkin, Date checkout, int nR, int gAd, int gCh) {
        this.nom_h=titre;
        this.desc=description;
        this.img=img;
        this.checkin=checkin;
        this.checkout=checkout;
        this.n_r=nR;
        this.g_ad=gAd;
        this.g_ch=gCh;

    }*/
}
