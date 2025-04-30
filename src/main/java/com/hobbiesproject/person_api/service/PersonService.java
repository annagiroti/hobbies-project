package com.hobbiesproject.person_api.service;

import com.hobbiesproject.person_api.api.model.Person;
import com.hobbiesproject.person_api.api.model.Hobby;

import java.util.List;

public interface PersonService {
    public String createPerson(Person person);
    public String updatePerson(Person person);
    public String deletePerson(String personID);
    public Person getPerson(String personID);
    public List<Person> getAllPeople();
    public String addHobbyToPerson(String personID, Hobby hobby);
    public List<Hobby> getHobbiesForPerson(String personID);
    public String updateHobbyForPerson(String personID, String hobbyID, Hobby hobby);
    public String deleteHobbyFromPerson(String personID, String hobbyID);
    public List<Person> findPeopleByHobbyName(String hobbyName);
}
