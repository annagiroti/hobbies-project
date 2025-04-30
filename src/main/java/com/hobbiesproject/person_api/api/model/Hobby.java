package com.hobbiesproject.person_api.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="hobby_info")
public class Hobby {
    @Id
    private String hobbyID;
    private String hobbyName;
    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;

    public Hobby() {
    }

    public Hobby(String hobbyID, String hobbyName) {
        this.hobbyID = hobbyID;
        this.hobbyName = hobbyName;
    }

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