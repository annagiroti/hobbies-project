package com.hobbiesproject.person_api.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="person_info")
public class Person {
    @Id
    private String personID;
    private String personName;
    private String personPhoneNumber;
    private String personAddress;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Hobby> hobbies = new ArrayList<>();

    public Person() {
    }
    public Person(String personID, String personName, String personPhoneNumber, String personAddress) {
        this.personID = personID;
        this.personName = personName;
        this.personPhoneNumber = personPhoneNumber;
        this.personAddress = personAddress;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonPhoneNumber() {
        return personPhoneNumber;
    }

    public void setPersonPhoneNumber(String personPhoneNumber) {
        this.personPhoneNumber = personPhoneNumber;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public void addHobby(Hobby hobby) {
        hobby.setPerson(this);
        this.hobbies.add(hobby);
    }

    public void removeHobby(Hobby hobby) {
        this.hobbies.remove(hobby);
        hobby.setPerson(null);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person person)) return false;
//        return Objects.equals(getPersonID(), person.getPersonID()) && Objects.equals(getPersonName(), person.getPersonName()) && Objects.equals(getPersonPhoneNumber(), person.getPersonPhoneNumber()) && Objects.equals(getPersonAddress(), person.getPersonAddress());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getPersonID(), getPersonName(), getPersonPhoneNumber(), getPersonAddress());
//    }
}