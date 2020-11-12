package com.example.demo.dto;

import java.util.HashSet;
import java.util.Set;

public class PersonNameAgePetDto {

    private String name;
    private int age;
    private Set<PetNameAgeDto> petNameAgeDtoSet = new HashSet<>();


    public Set<PetNameAgeDto> getPetNameAgeDtoSet() {
        return petNameAgeDtoSet;
    }

    public void setPetNameAgeDtoSet(Set<PetNameAgeDto> petNameAgeDtoSet) {
        this.petNameAgeDtoSet = petNameAgeDtoSet;
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
