package com.example.demo.entities;






import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person {

    Person(){

    }

    public Person(@NotBlank(message = "Name is mandatory")
                  @Size(max = 45, message = "Max is 45 ")
                  @Pattern(message = "incorrect name", regexp = "[A-X][a-z]+") String name,
                  @Min(value = 1, message = "Minimum is 1")
                  @Max(value = 150, message = "Maximum is 150")
                  @NotNull(message = "Age is mandatory") Integer age) {
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue
    private Long idPerson;

    @Column
    @NotBlank(message = "Name is mandatory")
    @Size(max =45, message = "Max is 45 ")
    @Pattern(message = "incorrect name", regexp = "[A-X][a-z]+")
    private String name;

    @Column
    @Min(value = 1, message = "Minimum is 1")
    @Max(value = 150, message = "Maximum is 150")
    @NotNull(message = "Age is mandatory")
    private Integer age;

    @ManyToMany
    @JoinTable(name = "pet_person",
            joinColumns = @JoinColumn(name = "id_person"),
//            inverseJoinColumns =@JoinColumn(name = "id_pet"),
            uniqueConstraints = {@UniqueConstraint(
            columnNames = {"id_person", "id_pet"})})
    private Set<Pet> petList;

    public Set<Pet> getPetList() {
        return petList;
    }

    public void setPetList(Set<Pet> petList) {
        this.petList = petList;
    }

    public void addPet(Pet pet) {
        this.petList.add(pet);
//        pet.getPersonList().add(this);
    }

    public void deletePet(Pet pet){

        this.petList.remove(pet);
        pet.getPersonSet().remove(this);
    }



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

    public Integer getAge() {

        return age;
    }

    public void setAge(Integer age){

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
