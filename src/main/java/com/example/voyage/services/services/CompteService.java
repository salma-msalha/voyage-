package com.example.voyage.services.services;

import com.example.voyage.entities.Compte;

import java.util.List;

public interface CompteService {
    public Compte addCompte(Compte compte);
    public Compte getCompte(long id);
    public List<Compte> getAllCompte();
    public Compte updateCompte(Compte compte, long id);
    public void deleteCompte(Long id);
}
