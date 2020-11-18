package com.example.demo.dto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PersonNameAgePetDto {
    public PersonNameAgePetDto(){}
    public PersonNameAgePetDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonNameAgePetDto dto = (PersonNameAgePetDto) o;
        return age == dto.age &&
                name.equals(dto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
