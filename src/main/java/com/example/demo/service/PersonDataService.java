package com.example.demo.service;

import com.example.demo.repositories.CustomizedPersonsJpa;
import com.example.demo.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class PersonDataService {

    @Autowired
    private CustomizedPersonsJpa customizedPersonsJpa;

    @Transactional
    public Person findPersonById(){
        Optional<Person> person = customizedPersonsJpa.findById(1L);
        return person.get();
    }

}
