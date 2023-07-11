package com.example.voyage.services.services;

import com.example.voyage.entities.Facture;

import java.util.List;

public interface FactureService {
    public Facture addFacture(Facture facture);
    public Facture getFacture(long id);
    public List<Facture> getAllFacture();
    public Facture updateFacture(Facture facture, long id);
    public void deleteFacture(Long id);
}
