package com.example.voyage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Reservation {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private Date date_reservation;
    @ManyToOne
    private Client Client;

}
