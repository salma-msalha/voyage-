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
    private String email ; 
    private String mdp ;
    private String role;
    public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getNom() {
		return nom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getN_Cin() {
		return N_Cin;
	}
	public void setN_Cin(String n_Cin) {
		N_Cin = n_Cin;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getN_passeport() {
		return N_passeport;
	}
	public void setN_passeport(String n_passeport) {
		N_passeport = n_passeport;
	}
	public String getTele() {
		return tele;
	}
	public void setTele(String tele) {
		this.tele = tele;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public List<Reservation> getReservations() {
		return Reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		Reservations = reservations;
	}
	
    @OneToMany(mappedBy = "Client")
    private List<Reservation> Reservations;
	
    
    
}
