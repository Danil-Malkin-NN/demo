package com.example.demo.controllers;

import com.example.demo.dto.PersonNameAgeDto;
import com.example.demo.entities.Person;
import com.example.demo.exeption.AgeException;
import com.example.demo.exeption.BadInputException;
import com.example.demo.exeption.NoPersonException;
import com.example.demo.service.PersonDataService;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    PersonDataService personDataService;

    @RequestMapping(value = "{id}" )
    public Person personById(@PathVariable("id") Long personId){

        return personService.getPersonById(personId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void putPerson(@RequestBody PersonNameAgeDto person) throws BadInputException {
            personService.addPerson(person);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void  deleteName(@PathVariable("id") Long personId) throws NoPersonException {

        personService.removePerson(personId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<?> getAllPerson (@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "short", defaultValue = "false", required = false) boolean shortPrint ){
        return personService.getListPersonWithParam(name, shortPrint);

    }










}
