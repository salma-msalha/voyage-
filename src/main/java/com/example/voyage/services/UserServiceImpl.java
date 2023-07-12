 package com.example.voyage.services;

import com.example.voyage.entities.Client;
import com.example.voyage.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepo;

    @Override
    public Client createUser(Client user) {
    	
        return userRepo.save(user);
    }

    
    public List<Client> getClients() {
        return userRepo.findAll();
    }
   

    public Client getClientById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    public Client getClientByName(String nom) {
        return userRepo.findByNom(nom);
    }
   

    public String deleteClient(Long id) {
        userRepo.deleteById(id);
        return "Client removed !! " + id;
    }

    
    public Client updateClient(Client Client) {
        Client existingClient = userRepo.findById((long) Client.getId()).orElse(null);
        existingClient.setNom(Client.getNom());
        existingClient.setEmail(Client.getEmail());
        existingClient.setTele(Client.getTele());
        return userRepo.save(existingClient);
    }
	
	@Override
    public boolean checkEmail(String email) {

        return userRepo.existsByEmail(email);
    }


	
    
}
