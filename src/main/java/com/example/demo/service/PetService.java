package com.example.demo.service;

import com.example.demo.dto.PetNameAgeDto;
import com.example.demo.entities.Pet;
import com.example.demo.exeption.NoEntitiesException;
import com.example.demo.repositories.CustomizedPetJpa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    static List<Pet> listPet = new ArrayList<>();

    @Autowired
    CustomizedPetJpa cpj;

    ModelMapper mapper = new ModelMapper();

    public  List<Pet> getListPet() {
        return listPet = cpj.findAll();
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
        List<Pet> petsList;
        petsList = name == null ? getListPet() : getListPetWithParam(name);

        return shortPrint ?
                getPetDtoList(petsList) : petsList;

    }

    public List<PetNameAgeDto> getPetDtoList(List<Pet> listPet){
        List<PetNameAgeDto> petNameAgeDtos = new ArrayList<>();
        for (Pet p: listPet){
            petNameAgeDtos.add(mapper.map(p, PetNameAgeDto.class));
        }
        return petNameAgeDtos;
    }

    public void addPerson(Long id){


    }



}
