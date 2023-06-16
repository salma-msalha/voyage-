package com.example.voyage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor@NoArgsConstructor@ToString
@Entity
@Table
public class Service {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String description ;
    private Double prixAchat;
    private Double prixVente ;
    private int qte;
}
