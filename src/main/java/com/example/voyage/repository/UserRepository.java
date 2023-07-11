package com.example.voyage.repository;


import com.example.voyage.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Client, Integer> {

    public boolean existsByEmail(String email);

    public Client findByEmail(String email);

    public Client findByNom(String nom);

}
