package com.example.demo.service;


import com.example.demo.entities.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    static List<Person> listPerson = new ArrayList<>();

    public List<Person> getListPerson() {
        return listPerson;
    }

    public void setListPerson(ArrayList<Person> listName) {
        PersonService.listPerson = listName;
    }

    public void addPerson(Person person){
        listPerson.add(person);
    }

    public void removePerson(Person person){
        listPerson.remove(person);
    }
}