package com.example.voyage.services.services;

import com.example.voyage.entities.Hotel;

import java.util.List;

public interface HotelService {
    public Hotel addHotel(Hotel hotel);
    public Hotel getHotel(long id);
    public List<Hotel> getAllHotel();
    public Hotel updateHotel(Hotel hotel, long id);
    public void deleteHotel(Long id);
}
