package com.example.demo.controllers;


import com.example.demo.service.PersonTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonTestController {

//    @Autowired
//    final PersonTestService personTestService;

    public PersonTestController(PersonTestService service ){
//        this.personTestService = service;
    }

    @RequestMapping(value = "/")
    public @ResponseBody String getAnswer(){
//       return personTestService.getAnswer();
        return "Hello";
    }

}
