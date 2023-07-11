package com.example.voyage.services.services;

import com.example.voyage.entities.Reservation;

import java.util.List;

public interface ReservationService {
    public Reservation addResevation(Reservation reservation);
    public Reservation getResevation(long id);
    public List<Reservation> getAllReservation();
    public Reservation updateResevation(Reservation reservation, long id);
    public void deleteReservation(Long id);
}
