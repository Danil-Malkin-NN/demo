package com.example.demo.repositories;

import com.example.demo.entities.Person;
import com.example.demo.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomizedPetJpa extends JpaRepository<Pet, Long> {
    public List<Pet> findAllByName(String name);


}
