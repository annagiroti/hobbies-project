package com.hobbiesproject.person_api.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing a Person
 * Each Person can have multiple Hobbies (One-to-Many relationship)
 */
@Entity
@Table(name = "person_info")
public class Person {

    // Primary key of the Person entity
    @Id
    private String personID;
    private String personName;
    private String personPhoneNumber;
    private String personAddress;

    /**
     * One-to-Many relationship with Hobby entity.
     * 'mappedBy' indicates that the 'person' field in Hobby owns the relationship
     * 'cascade = CascadeType.ALL' propagates all persistence operations to hobbies
     * 'orphanRemoval = true' ensures that if a hobby is removed from the list,
     * it will also be removed from the database
     */
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // Prevents circular reference during JSON serialization
    private List<Hobby> hobbies = new ArrayList<>();

    // Default no-args constructor required by JPA
    public Person() {
    }

    // Constructor to initialize Person fields
    public Person(String personID, String personName, String personPhoneNumber, String personAddress) {
        this.personID = personID;
        this.personName = personName;
        this.personPhoneNumber = personPhoneNumber;
        this.personAddress = personAddress;
    }

    // Getters and Setters
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

    // Add a hobby to this person and set the back-reference
    public void addHobby(Hobby hobby) {
        hobby.setPerson(this);
        this.hobbies.add(hobby);
    }

    // Remove a hobby from this person and clear the back-reference
    public void removeHobby(Hobby hobby) {
        this.hobbies.remove(hobby);
        hobby.setPerson(null);
    }

    // Unused code in current set-up, can be toggled back on - app hasn't been tested with it on

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