package com.hobbiesproject.person_api.service.impl;

import com.hobbiesproject.person_api.api.model.Hobby;
import com.hobbiesproject.person_api.api.model.Person;
import com.hobbiesproject.person_api.repository.PersonRepository;
import com.hobbiesproject.person_api.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of PersonService interface.
 * Contains business logic for managing Person and their associated Hobbies.
 */
@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Create a new person and assigns person reference to each hobby if any in person database
    @Override
    public String createPerson(Person person) {
        if (person.getHobbies() != null) {
            for (Hobby hobby : person.getHobbies()) {
                hobby.setPerson(person);
            }
        }
        personRepository.save(person);
        return "Success";
    }

    // Update an existing person from person database
    @Override
    public String updatePerson(Person person) {
        personRepository.save(person);
        return "Success";
    }

    // Delete a specific person from person database by their ID
    @Override
    public String deletePerson(String personID) {
        personRepository.deleteById(personID);
        return "Success";
    }

    // Read a specific person from person database by their ID
    @Override
    public Person getPerson(String personID) {
        // return new Person("1", "John Doe", "XXXX","Address 1");
        return personRepository.findById(personID).get();
    }

    // Read all people from person database
    @Override
    public List<Person> getAllPeople() {
//        Person[] persons = {new Person("1", "John Doe", "XXXX","Address 1"),
//                new Person("2", "Jane Doe", "YYYY","Address 2")};
//        return Arrays.asList(persons);
        return personRepository.findAll();
    }

    // Add a new hobby to an existing person from person database by their ID
    @Override
    public String addHobbyToPerson(String personID, Hobby hobby) {
        Person person = personRepository.findById(personID).orElseThrow();
        hobby.setPerson(person);
        person.getHobbies().add(hobby);
        personRepository.save(person);
        return "Success";
    }

    // Read all hobbies for a specific person from person database by their ID
    @Override
    public List<Hobby> getHobbiesForPerson(String personID) {
        Person person = personRepository.findById(personID).orElseThrow();
        return person.getHobbies();
    }

    // Update a hobby for a specific person from person database by their ID and hobby ID
    @Override
    public String updateHobbyForPerson(String personID, String hobbyID, Hobby updatedHobby) {
        Person person = personRepository.findById(personID).orElseThrow();
        for (Hobby hobby : person.getHobbies()) {
            if (hobby.getHobbyID().equals(hobbyID)) {
                hobby.setHobbyName(updatedHobby.getHobbyName());
            }
        }
        personRepository.save(person);
        return "Success";
    }

    // Delete a hobby for a specific person from person database by their ID and hobby ID
    @Override
    public String deleteHobbyFromPerson(String personID, String hobbyID) {
        Person person = personRepository.findById(personID).orElseThrow();
        person.getHobbies().removeIf(hobby -> hobby.getHobbyID().equals(hobbyID));
        personRepository.save(person);
        return "Success";
    }

    // Finds all people who have a hobby with a specific name
    @Override
    public List<Person> findPeopleByHobbyName(String hobbyName) {
        return personRepository.findByHobbies_HobbyName(hobbyName);
    }
}