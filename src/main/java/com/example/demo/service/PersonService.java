package com.example.demo.service;


import com.example.demo.dto.PersonIdNameDto;
import com.example.demo.dto.PersonNameAgeDto;
import com.example.demo.entities.Person;
import com.example.demo.exeption.BadInputException;
import com.example.demo.exeption.NoPersonException;
import com.example.demo.repositories.CustomizedPersonsJpa;
import org.hibernate.HibernateError;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    static List<Person> listPerson = new ArrayList<>();

    @Autowired
    CustomizedPersonsJpa customizedPersonsJpa;


    ModelMapper mapper = new ModelMapper();

    public List<Person> getListPerson() {

        return  customizedPersonsJpa.findAll();
    }

    public void setListPerson(ArrayList<Person> listName) {
        PersonService.listPerson = listName;
    }

    public void addPerson(PersonNameAgeDto person) throws BadInputException {
        try{
            customizedPersonsJpa.save(mapper.map(person, Person.class));
        }catch (ValidationException e){
            throw new BadInputException("bam");
        } catch (ConstraintViolationException e){
            System.out.println("safsdf");
        }
//        javax.validation.ConstraintViolationException


    }

    public void removePerson(Long id) throws NoPersonException{
        if(customizedPersonsJpa.existsById(id)){
            customizedPersonsJpa.deleteById(id);
        }else{
           throw  new NoPersonException("Person does not exist");
        }
    }

    public Person getPersonById(Long id) {
        return customizedPersonsJpa.findById(id).get();
    }

    public List<Person> getListPersonWithParam(String name){
        return customizedPersonsJpa.findAllByName(name);
    }

    public List<?> getListPersonWithParam(String name, boolean shortPrint){
        List<Person> personList;
        personList = name == null ? getListPerson() : getListPersonWithParam(name);

         return shortPrint ?
               getPersonDtoList(personList) : personList;

    }

    public List<PersonIdNameDto> getPersonDtoList(List<Person> personList){
        //Использовать мапер
        List<PersonIdNameDto> personIdNameDto = new ArrayList<>();


        for(Person p : personList){
           personIdNameDto.add(mapper.map(p, PersonIdNameDto.class));
        }

        return personIdNameDto;
    }

}