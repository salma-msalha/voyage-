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

    
    @Override
    public Client updateClient(Client client) {
        Client existingClient = userRepo.findById(client.getId()).orElse(null);
        if (existingClient != null) {
            existingClient.setNom(client.getNom());
            existingClient.setPrenom(client.getPrenom());
            existingClient.setN_Cin(client.getN_Cin());
            existingClient.setEmail(client.getEmail());
            existingClient.setTele(client.getTele());
           return userRepo.save(existingClient);
        }
        return null; // Gérer le cas où le client n'est pas trouvé
    }

	
	@Override
    public boolean checkEmail(String email) {

        return userRepo.existsByEmail(email);
    }


	
    
}
