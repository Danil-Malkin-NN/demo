package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.controllers.PersonController;
import com.example.demo.dto.PersonNameAgePetDto;
import com.example.demo.service.PersonService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


//@SpringBootTest
////@RunWith(SpringRunner.class)
//public class TestPersonController {
//    @MockBean
//    PersonController personController;
//
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void firstTest() throws Exception {
//
//        PersonNameAgePetDto expectedDto = new PersonNameAgePetDto();
//        expectedDto.setAge(10);
//        expectedDto.setName("Oleg");
//        expectedDto.setPetList(null);
//
//
//        when(personController.getPersonById(100L)).thenReturn(expectedDto);
//        personController.getPersonById(100L);
//        this.mockMvc.perform(get("/api/person/100").contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].name", is(expectedDto.getName())))
//                .andExpect(jsonPath("$[1].age", is(expectedDto.getAge())));
//
//    }
//
//}
