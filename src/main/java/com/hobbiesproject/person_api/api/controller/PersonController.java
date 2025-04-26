package com.hobbiesproject.person_api.api.controller;

import com.hobbiesproject.person_api.api.model.Person;
import com.hobbiesproject.person_api.api.model.Hobby;
import com.hobbiesproject.person_api.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    // Read specific person details from person database
    @GetMapping("/{personID}")
    public Person getPersonDetails(@PathVariable("personID") String personID) {
        return personService.getPerson(personID);
    }
    // Read all people details from person database
    @GetMapping()
    public List<Person> getAllPeopleDetails() {
        return personService.getAllPeople();
    }

    @PostMapping()
    public String createPersonDetails(@RequestBody Person person) {
        personService.createPerson(person);
        return "Person created successfully";
    }

    @PutMapping()
    public String updatePersonDetails(@RequestBody Person person) {
        personService.updatePerson(person);
        return "Person updated successfully";
    }

    @DeleteMapping("/{personID}")
    public String deletePersonDetails(@PathVariable("personID") String personID) {
        personService.deletePerson(personID);
        return "Person deleted successfully";
    }

    @PostMapping("/{personID}/hobbies")
    public String addHobbyToPerson(@PathVariable String personID, @RequestBody Hobby hobby) {
        personService.addHobbyToPerson(personID, hobby);
        return "Hobby added to person successfully.";
    }
    @GetMapping("/{personID}/hobbies")
    public List<Hobby> getHobbiesForPerson(@PathVariable String personID) {
        return personService.getHobbiesForPerson(personID);
    }
    @PutMapping("/{personID}/hobbies/{hobbyID}")
    public String updateHobbyForPerson(@PathVariable String personID,
                                       @PathVariable String hobbyID,
                                       @RequestBody Hobby updatedHobby) {
        personService.updateHobbyForPerson(personID, hobbyID, updatedHobby);
        return "Hobby updated for person successfully";
    }
    @DeleteMapping("/{personID}/hobbies/{hobbyID}")
    public String deleteHobbyFromPerson(@PathVariable String personID,
                                        @PathVariable String hobbyID) {
        personService.deleteHobbyFromPerson(personID, hobbyID);
        return "Hobby removed from person successfully";
    }
}
