package com.example.demo;

import com.example.demo.controllers.PersonController;
import com.example.demo.dto.PersonNameAgePetDto;
import com.example.demo.entities.Person;
import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.ModelMapper;


public class TestMapperDto {

    ModelMapper mapper = new ModelMapper();

    @Test
    public void testToPersonDto() throws Exception{
        //Входные данные
        Person person = new Person("Oleg", 10);
        //Правильный ответ
        PersonNameAgePetDto  dto = new PersonNameAgePetDto("Oleg", 10);

        Assert.assertTrue(mapper.map(person, PersonNameAgePetDto.class).equals(dto));
    }

}
