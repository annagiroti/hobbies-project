package com.hobbiesproject.person_api.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

/**
 * Entity class representing a Hobby
 * Each Hobby is associated with one Person (Many-to-One relationship)
 */
@Entity
@Table(name = "hobby_info")
public class Hobby {

    // Primary key of the Hobby entity
    @Id
    private String hobbyID;
    private String hobbyName;

    // Many-to-One relationship: Many hobbies can belong to one person
    @ManyToOne
    @JoinColumn(name = "person_id")  // Foreign key column in the hobby_info table
    @JsonBackReference  // Prevents circular reference during JSON serialization
    private Person person;

    // Default no-args constructor required by JPA
    public Hobby() {
    }

    // Constructor to initialize hobbyID and hobbyName
    public Hobby(String hobbyID, String hobbyName) {
        this.hobbyID = hobbyID;
        this.hobbyName = hobbyName;
    }

    // Getters and Setters for Hobbies
    public String getHobbyID() {
        return hobbyID;
    }

    public void setHobbyID(String hobbyID) {
        this.hobbyID = hobbyID;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}