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
public class Pack {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private Date date_debut ;
    private Date date_fin;
    private String Description;
    private Double prxMini;
}
