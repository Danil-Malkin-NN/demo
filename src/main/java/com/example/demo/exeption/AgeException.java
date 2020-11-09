package com.example.demo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.BAD_REQUEST)
public class AgeException extends Exception{
//    String mes = "Age cannot be more than 200 or less than 1";


    public AgeException(String message){

        super(message);

    }


}
