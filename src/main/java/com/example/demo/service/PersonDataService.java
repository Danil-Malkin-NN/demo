package com.example.demo.service;

import com.example.demo.repositories.CustomizedPersonsCrud;
import com.example.demo.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
public class PersonDataService {

    @Autowired
    private CustomizedPersonsCrud customizedPersonsCrud;

    @Transactional
    public void findPersonById(){
        Optional<Person> person = customizedPersonsCrud.findById(1L);

    }


}
