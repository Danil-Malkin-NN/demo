package com.example.demo.entities;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table
public class Pet {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    @NotBlank(message = "Name is mandatory")
    @Size(max =45, message = "Max is 45 ")
    @Pattern(message = "incorrect name", regexp = "[A-X][a-z]+")
    private String name;

    @Column
    @Min(value = 1, message = "Minimum is 1")
    @Max(value = 300, message = "Maximum is 300")
    @NotNull(message = "Age is mandatory")
    private Integer age;

    @ManyToMany
    @JoinTable(name = "pet_person",
            joinColumns = @JoinColumn(name = "id_pet"),
            inverseJoinColumns =@JoinColumn(name = "id_person")
    )
    private Set<Person> personSet;

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
