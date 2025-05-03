package com.hobbiesproject.person_api.api.controller;

import com.hobbiesproject.person_api.api.model.Person;
import com.hobbiesproject.person_api.api.model.Hobby;
import com.hobbiesproject.person_api.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller to manage Person-related operations,
 * including managing their associated hobbies
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Read specific person details by their ID
    @GetMapping("/{personID}")
    public Person getPersonDetails(@PathVariable("personID") String personID) {
        return personService.getPerson(personID);
    }

    // Read all people details
    @GetMapping()
    public List<Person> getAllPeopleDetails() {
        return personService.getAllPeople();
    }

    // Create a new person
    @PostMapping()
    public String createPersonDetails(@RequestBody Person person) {
        personService.createPerson(person);
        return "Person created successfully";
    }

    // Update an existing person
    @PutMapping()
    public String updatePersonDetails(@RequestBody Person person) {
        personService.updatePerson(person);
        return "Person updated successfully";
    }

    // Delete a person by their ID
    @DeleteMapping("/{personID}")
    public String deletePersonDetails(@PathVariable("personID") String personID) {
        personService.deletePerson(personID);
        return "Person deleted successfully";
    }

    // Create a new hobby for a specific person
    @PostMapping("/{personID}/hobbies")
    public String addHobbyToPerson(@PathVariable String personID, @RequestBody Hobby hobby) {
        personService.addHobbyToPerson(personID, hobby);
        return "Hobby added to person successfully.";
    }

    // Read all hobbies associated to a specific person
    @GetMapping("/{personID}/hobbies")
    public List<Hobby> getHobbiesForPerson(@PathVariable String personID) {
        return personService.getHobbiesForPerson(personID);
    }

    // Update a specific hobby for a specific person
    @PutMapping("/{personID}/hobbies/{hobbyID}")
    public String updateHobbyForPerson(@PathVariable String personID,
                                       @PathVariable String hobbyID,
                                       @RequestBody Hobby updatedHobby) {
        personService.updateHobbyForPerson(personID, hobbyID, updatedHobby);
        return "Hobby updated for person successfully";
    }

    // Delete a specific hobby for a specific person
    @DeleteMapping("/{personID}/hobbies/{hobbyID}")
    public String deleteHobbyFromPerson(@PathVariable String personID,
                                        @PathVariable String hobbyID) {
        personService.deleteHobbyFromPerson(personID, hobbyID);
        return "Hobby removed from person successfully";
    }

    // Find all people who have a specific hobby by name
    @GetMapping("/search-by-hobby")
    public List<Person> findPeopleByHobbyName(@RequestParam String hobbyName) {
        return personService.findPeopleByHobbyName(hobbyName);
    }
}