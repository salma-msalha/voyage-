package com.example.voyage.repository;

import com.example.voyage.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResevationRepository extends JpaRepository<Reservation,Long> {
}
