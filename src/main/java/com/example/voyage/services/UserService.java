package com.example.voyage.services;

import java.util.List;

import com.example.voyage.entities.Client;


public interface UserService {

    public Client createUser(Client user);

    public boolean checkEmail(String email);

	public List<Client> getClients();

	public Client getClientByName(String nom);

	public Client updateClient(Client client);

	public String deleteClient(Long id);

	public Client getClientById(long clientId);

	

}