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
public class Vol {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int NVol;
    private Date dateA;
    private Date dateR;
    private String typeA;
    private String typeB;
    private String Aheured;
    private String Aheurea;
    private String Rheured;
    private String Rheurea;
    private String avionA;
    private String avionR;
    private String villeA;
    private String villeR;
    @ManyToOne
    private Client Client;
    @OneToMany
    private List<Reservation> reservations;

    public Vol(int NVol, Date dateA, Date dateR, String typeA, String typeB, String aheured, String aheurea, String rheured, String rheurea, String avionA, String avionR, String villeA, String villeR, com.example.voyage.entities.Client client) {
        this.NVol = NVol;
        this.dateA = dateA;
        this.dateR = dateR;
        this.typeA = typeA;
        this.typeB = typeB;
        Aheured = aheured;
        Aheurea = aheurea;
        Rheured = rheured;
        Rheurea = rheurea;
        this.avionA = avionA;
        this.avionR = avionR;
        this.villeA = villeA;
        this.villeR = villeR;
        Client = client;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getNVol() {
        return NVol;
    }

    public void setNVol(int NVol) {
        this.NVol = NVol;
    }

    public Date getDateA() {
        return dateA;
    }

    public void setDateA(Date dateA) {
        this.dateA = dateA;
    }

    public Date getDateR() {
        return dateR;
    }

    public void setDateR(Date dateR) {
        this.dateR = dateR;
    }

    public String getTypeA() {
        return typeA;
    }

    public void setTypeA(String typeA) {
        this.typeA = typeA;
    }

    public String getTypeB() {
        return typeB;
    }

    public void setTypeB(String typeB) {
        this.typeB = typeB;
    }

    public String getAheured() {
        return Aheured;
    }

    public void setAheured(String aheured) {
        Aheured = aheured;
    }

    public String getAheurea() {
        return Aheurea;
    }

    public void setAheurea(String aheurea) {
        Aheurea = aheurea;
    }

    public String getRheured() {
        return Rheured;
    }

    public void setRheured(String rheured) {
        Rheured = rheured;
    }

    public String getRheurea() {
        return Rheurea;
    }

    public void setRheurea(String rheurea) {
        Rheurea = rheurea;
    }

    public String getAvionA() {
        return avionA;
    }

    public void setAvionA(String avionA) {
        this.avionA = avionA;
    }

    public String getAvionR() {
        return avionR;
    }

    public void setAvionR(String avionR) {
        this.avionR = avionR;
    }

    public String getVilleA() {
        return villeA;
    }

    public void setVilleA(String villeA) {
        this.villeA = villeA;
    }

    public String getVilleR() {
        return villeR;
    }

    public void setVilleR(String villeR) {
        this.villeR = villeR;
    }

    public com.example.voyage.entities.Client getClient() {
        return Client;
    }

    public void setClient(com.example.voyage.entities.Client client) {
        Client = client;
    }
}
