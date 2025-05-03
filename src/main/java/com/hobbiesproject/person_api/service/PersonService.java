package com.hobbiesproject.person_api.service;

import com.hobbiesproject.person_api.api.model.Person;
import com.hobbiesproject.person_api.api.model.Hobby;

import java.util.List;

/**
 * Service interface for managing Person-related business logic,
 * including CRUD operations and interactions with hobbies
 */
public interface PersonService {

    // Create a new person
    public String createPerson(Person person);

    // Update an existing person
    public String updatePerson(Person person);

    // Delete a specific person by their ID
    public String deletePerson(String personID);

    // Read a specific person by their ID
    public Person getPerson(String personID);

    // Read all people
    public List<Person> getAllPeople();

    // Add a hobby to an existing person
    public String addHobbyToPerson(String personID, Hobby hobby);

    // Read all hobbies of a specific person
    public List<Hobby> getHobbiesForPerson(String personID);

    // Update a specific hobby for a specific person
    public String updateHobbyForPerson(String personID, String hobbyID, Hobby hobby);

    // Delete a specific hobby for a specific person
    public String deleteHobbyFromPerson(String personID, String hobbyID);

    // Find all people who have a hobby with the given name
    public List<Person> findPeopleByHobbyName(String hobbyName);
}
