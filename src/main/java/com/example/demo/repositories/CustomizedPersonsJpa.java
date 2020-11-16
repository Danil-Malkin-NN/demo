package com.example.demo.repositories;


import com.example.demo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomizedPersonsJpa extends JpaRepository<Person, Long> {

    Optional<Person> findByName(String name);
    List<Person> findAllByName(String name);
    Person findPersonById(Long id);


}
