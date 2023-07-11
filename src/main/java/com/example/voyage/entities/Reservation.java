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
    
    

}
