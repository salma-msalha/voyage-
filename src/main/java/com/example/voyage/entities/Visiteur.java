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
public class Visiteur {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
}
