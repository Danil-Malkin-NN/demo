package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

public class PersonNameAgePetDto {

    private String name;
    private int age;
    private Set<PetNameAgeDto> petList = new HashSet<>();


    public Set<PetNameAgeDto> getPetList() {
        return petList;
    }

    public void setPetList(Set<PetNameAgeDto> petList) {
        this.petList = petList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
