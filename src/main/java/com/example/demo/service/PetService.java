package com.example.demo.service;

import com.example.demo.dto.PetNameAgeDto;
import com.example.demo.dto.PetNameAgePersonDto;
import com.example.demo.entities.Person;
import com.example.demo.entities.Pet;
import com.example.demo.exeption.NoEntitiesException;
import com.example.demo.repositories.CustomizedPetJpa;
import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    static List<Pet> listPet = new ArrayList<>();

    @Autowired
    CustomizedPetJpa cpj;

    ModelMapper mapper = new ModelMapper();

    public  List<?> getListPet() {

        return getPersonDtoList(cpj.findAll(), PetNameAgePersonDto.class);
    }

    public void addPet(Pet pet){
        cpj.save(pet);
    }

    public void removePet(Long id) throws NoEntitiesException {
        if(cpj.existsById(id)){
            cpj.deleteById(id);
        }else{
            throw new NoEntitiesException("Pet does not exist");
        }

    }

    public Pet getPetById(long id){
         return cpj.findById(id).get();
    }

    public List<Pet> getListPetWithParam(String name){
        return cpj.findAllByName(name);
    }

    public List<?> getListPetWithParam(String name, boolean shortPrint){
        List<?> petsList;
        petsList = name == null ? getListPet() : getListPetWithParam(name);

        return shortPrint ?
                getPersonDtoList(petsList, PetNameAgeDto.class) : petsList;

    }


    public List<?> getPersonDtoList(List<?> personList, Type dtoClass){

        List<?> dto = new ArrayList<>();
        personList.forEach(person -> {
            dto.add(mapper.map(person, dtoClass));
        });

        return dto;
    }





}
