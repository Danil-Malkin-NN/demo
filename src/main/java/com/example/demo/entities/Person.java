package com.example.demo.entities;

import com.example.demo.exeption.AgeException;

import org.springframework.lang.NonNull;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private Long idPerson;
    @Column(nullable = false,scale = 1)
    private String name;
    @Column
    private int age;

    public Person(){}

    public Person(String name) {
        this.name = name;
    }

    public Person (String name, int age){
        this.age = age;
        this.name = name;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
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

    public void setAge(int age) throws AgeException {
//        if(age < 0 || age > 200) throw new AgeException("ERROR");
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


}
