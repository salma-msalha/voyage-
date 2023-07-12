package com.example.voyage.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Facture {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String reservation;
    private Double total;
    @ManyToOne
    private Reservation Reserv ;
}
