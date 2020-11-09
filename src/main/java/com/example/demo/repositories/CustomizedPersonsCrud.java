package com.example.demo.repositories;


import com.example.demo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomizedPersonsCrud extends JpaRepository<Person, Long> {

    Optional<Person> findByName(String name);


}
