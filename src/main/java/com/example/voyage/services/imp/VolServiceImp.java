package com.example.voyage.services.imp;

import com.example.voyage.entities.Vol;
import com.example.voyage.repository.VolRepository;
import com.example.voyage.services.services.VolService;

import java.util.List;

public class VolServiceImp implements VolService {
    private final VolRepository volRepository;


    public VolServiceImp(VolRepository volRepository) {
        this.volRepository = volRepository;
    }

    @Override
    public Vol addVol(Vol vol) {
        return volRepository.save(vol);
    }

    @Override
    public Vol getVol(long id) {
        return volRepository.findById(id).get();
    }

    @Override
    public List<Vol> getAllVol() {
        return volRepository.findAll();
    }
}
