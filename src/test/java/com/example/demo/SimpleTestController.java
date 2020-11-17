package com.example.demo;


import com.example.demo.controllers.PersonController;
import com.example.demo.dto.PersonNameAgePetDto;
import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class SimpleTestController {

    @MockBean
    private PersonService personService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testReturn200() throws Exception {
        given(personService.getPersonById(1L)).willReturn(new PersonNameAgePetDto("Valera", 20));
        mockMvc.perform(get("/person/1"))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }
}
