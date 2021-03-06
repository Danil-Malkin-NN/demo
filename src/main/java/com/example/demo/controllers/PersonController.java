package com.example.demo.controllers;

import com.example.demo.dto.PersonNameAgePetDto;
import com.example.demo.entities.Person;
import com.example.demo.exeption.NoEntitiesException;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    PersonService personService;



    @RequestMapping(value = "{id}" )
    public PersonNameAgePetDto getPersonById(@PathVariable("id") Long personId){

        return personService.getPersonById(personId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> putPerson(@Valid @RequestBody Person person)  {
            personService.addPerson(person);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void  deleteName(@PathVariable("id") Long personId) throws NoEntitiesException {

        personService.removePerson(personId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<?> getAllPerson (@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "short", defaultValue = "false", required = false) boolean shortPrint ){
        return personService.getListPersonWithParam(name, shortPrint);

    }

    @RequestMapping(value = "{id}/pet/{idPet}", method = RequestMethod.POST)
    public void addPetPerson(@PathVariable(value = "id") Long idPerson,
                             @PathVariable(value = "idPet") Long idPet){
        personService.addPet(idPerson, idPet);

    }

    @RequestMapping(value = "{id}/pet/{idPet}", method = RequestMethod.DELETE)
    public void deletePetPerson(@PathVariable(value = "id") Long idPerson,
                          @PathVariable(value = "idPet") Long idPet){
        personService.deletePet(idPerson, idPet);

    }





}
