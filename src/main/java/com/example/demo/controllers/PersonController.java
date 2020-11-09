package com.example.demo.controllers;

import com.example.demo.entities.Person;
import com.example.demo.exeption.AgeException;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {


    @Autowired
    PersonService personService;

    @RequestMapping(value = "/api/names", method = RequestMethod.GET)
    public List<Person> personService (){
        return personService.getListPerson();

    }

    @RequestMapping(value = "/api/names", method = RequestMethod.POST)
    public void putPerson(@RequestBody Person person) throws AgeException {
            personService.addPerson(person);
    }

    @RequestMapping(value = "/api/names", method = RequestMethod.DELETE)
    public void  deleteName(@RequestBody Person person){
        personService.removePerson(person);
    }


   // @RequestMapping(value = "yourApi", method = RequestMethod.DELETE)





}
