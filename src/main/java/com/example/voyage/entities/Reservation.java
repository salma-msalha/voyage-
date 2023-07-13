package com.example.voyage.entities;

import javax.persistence.*;
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
public class Reservation {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private Date date_reservation;
    @ManyToOne
    private Client Client;
    @ManyToOne
    private Vol vol;
    @ManyToOne
    private Hotel hotel;

   
    
   // @ManyToMany(mappedBy = "reservations")
   // private Set<Transport> transports= new HashSet<>();
   @OneToMany(mappedBy = "Reserv")
    private List<Facture> factures;



public long getID() {
	return ID;
}



public void setID(long iD) {
	ID = iD;
}



public Date getDate_reservation() {
	return date_reservation;
}



public void setDate_reservation(Date date_reservation) {
	this.date_reservation = date_reservation;
}



public Client getClient() {
	return Client;
}



public void setClient(Client client) {
	Client = client;
}



public Vol getVol() {
	return vol;
}



public void setVol(Vol vol) {
	this.vol = vol;
}



public Hotel getHotel() {
	return hotel;
}



public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}



public List<Facture> getFactures() {
	return factures;
}



public void setFactures(List<Facture> factures) {
	this.factures = factures;
}






    
    

}
