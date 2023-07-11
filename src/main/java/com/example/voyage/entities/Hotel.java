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

    private long id_hotel;
    private String nom_h;
    private String ville;
    private int g_ch;
    private int g_ad;
    private int n_r;
    private Date checkin;
    private Date checkout;
    private String descrip;
    private String imag;

    @OneToMany
    private List<Reservation> reservations;
    public Hotel(String nom_h, int g_ch, int g_ad, int n_r, Date checkin, Date checkout, String descrip, String imag) {
        this.nom_h = nom_h;
        this.g_ch = g_ch;
        this.g_ad = g_ad;
        this.n_r = n_r;
        this.checkin = checkin;
        this.checkout = checkout;
        this.descrip = descrip;
        this.imag = imag;
    }

    public String getNom_h() {
        return nom_h;
    }

    public void setNom_h(String nom_h) {
        this.nom_h = nom_h;
    }

    public int getG_ch() {
        return g_ch;
    }

    public void setG_ch(int g_ch) {
        this.g_ch = g_ch;
    }

    public int getG_ad() {
        return g_ad;
    }

    public void setG_ad(int g_ad) {
        this.g_ad = g_ad;
    }

    public int getN_r() {
        return n_r;
    }

    public void setN_r(int n_r) {
        this.n_r = n_r;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}