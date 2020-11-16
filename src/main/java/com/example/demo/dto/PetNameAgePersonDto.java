package com.example.demo.dto;

import com.example.demo.entities.Person;

import java.util.HashSet;
import java.util.Set;

public class PetNameAgePersonDto {

    private String name;
    private Integer age;
    private Set<PetNameAgeDto> personSet = new HashSet<>();

    public Set<PetNameAgeDto> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<PetNameAgeDto> personSet) {
        this.personSet = personSet;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
