package com.example.demo.controllers;


import com.example.demo.entities.Pet;
import com.example.demo.exeption.NoEntitiesException;
import com.example.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pet")
public class PetController {

    @Autowired
    PetService petService;

    @RequestMapping(method = RequestMethod.GET)
    public List<?> getAllPet(@RequestParam(value = "name", required = false) String name,
                             @RequestParam(value = "short", defaultValue = "false", required = false) boolean shor){

       return petService.getListPetWithParam(name, shor);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void putPet(@Valid @RequestBody Pet pet){
        petService.addPet(pet);
    }

    @RequestMapping(value = "{id}", method =  RequestMethod.DELETE)
    public void deletePet(@PathVariable("id") Long petId)throws NoEntitiesException {
        petService.removePet(petId);
    }

//    @RequestMapping(value = "/add", method = RequestMethod.POST)
//    public void addPerson(@RequestParam(value = "id") Long id){
//        petService.add
//    }







}
