package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.controllers.PersonController;
import com.example.demo.dto.PersonNameAgePetDto;
import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;

import com.example.demo.service.PetService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonController.class)
public class TestPersonController {


    @MockBean
    PersonService personService;
    @MockBean
    PetService petService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPersonByIdTest() throws Exception {

        PersonNameAgePetDto expectedDto = new PersonNameAgePetDto("Valera", 100);


        when(personService.getPersonById(100L)).thenReturn(expectedDto);

        this.mockMvc.perform(get("/api/person/100").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(expectedDto.getName())))
                .andExpect(jsonPath("$.age", is(expectedDto.getAge())));

    }


    @Test
    public void addNewPerson() throws Exception {

        Person person = new Person("Valera", 100);


        when(personService.addPerson(person));

        this.mockMvc.perform(get("/api/person/100").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(expectedDto.getName())))
                .andExpect(jsonPath("$.age", is(expectedDto.getAge())));

    }




//    @Test
//    public void addNewPerson() throws Exception {
//
//
//        this.mockMvc.perform(post("/api/person")).
//
//    }



}
