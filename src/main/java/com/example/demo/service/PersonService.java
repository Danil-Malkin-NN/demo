package com.example.demo.service;


import com.example.demo.dto.PersonIdNameDto;
import com.example.demo.dto.PersonNameAgePetDto;
import com.example.demo.entities.Person;
import com.example.demo.exeption.NoEntitiesException;
import com.example.demo.repositories.CustomizedPersonsJpa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    static List<Person> listPerson = new ArrayList<>();

    @Autowired
    CustomizedPersonsJpa customizedPersonsJpa;
    @Autowired
    PetService petService;

    ModelMapper mapper = new ModelMapper();

    public List<?> getListPerson() {

        return getPersonDtoList(customizedPersonsJpa.findAll(), PersonNameAgePetDto.class);

    }

    public void addPerson(Person person)  {
        customizedPersonsJpa.save(person);
    }

    public void removePerson(Long id) throws NoEntitiesException {
        if(customizedPersonsJpa.existsById(id)){
            customizedPersonsJpa.deleteById(id);
        }else{
           throw  new NoEntitiesException("Person does not exist");
        }
    }

    public PersonNameAgePetDto getPersonById(Long id) {
        return mapper.map(customizedPersonsJpa.findById(id).get(), PersonNameAgePetDto.class);
    }

    public List<Person> getListPersonWithParam(String name){
        return customizedPersonsJpa.findAllByName(name);
    }

    public List<?> getListPersonWithParam(String name, boolean shortPrint){
        List<?> personList;
        personList = name == null ? getListPerson() : getListPersonWithParam(name);

         return shortPrint ?
               getPersonDtoList(personList, PersonIdNameDto.class) : personList;

    }

    public List<?> getPersonDtoList(List<?> personList, Type dtoClass){

        List<?> dto = new ArrayList<>();
        personList.forEach(person -> {
            dto.add(mapper.map(person, dtoClass));
        });

        return dto;
    }


    public void addPet(Long idPerson, Long idPet){
        Person person  = customizedPersonsJpa.findPersonByIdPerson(idPerson);

        person.addPet(petService.getPetById(idPet));

        customizedPersonsJpa.save(person);
    }

    public void deletePet(Long idPerson, Long idPet){
        Person person = customizedPersonsJpa.findPersonByIdPerson(idPerson);
        person.deletePet(petService.getPetById(idPet));
        customizedPersonsJpa.save(person);


    }




}