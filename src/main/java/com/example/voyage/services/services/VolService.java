package com.example.voyage.services.services;

import com.example.voyage.entities.Vol;

import java.util.List;

public interface VolService {
    public Vol addVol(Vol vol);
    public Vol getVol(long id);
    public List<Vol> getAllVol();


}
