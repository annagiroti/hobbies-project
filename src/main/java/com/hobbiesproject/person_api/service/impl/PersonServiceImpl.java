package com.hobbiesproject.person_api.service.impl;

import com.hobbiesproject.person_api.api.model.Hobby;
import com.hobbiesproject.person_api.api.model.Person;
import com.hobbiesproject.person_api.repository.PersonRepository;
import com.hobbiesproject.person_api.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public String createPerson(Person person){
        if (person.getHobbies() != null) {
            for (Hobby hobby : person.getHobbies()) {
                hobby.setPerson(person);
            }
        }
        personRepository.save(person);
        return "Success";
    }
    @Override
    public String updatePerson(Person person){
        personRepository.save(person);
        return "Success";
    }
    @Override
    public String deletePerson(String personID){
        personRepository.deleteById(personID);
        return "Success";
    }
    @Override
    public Person getPerson(String personID){
        // return new Person("1", "John Doe", "XXXX","Address 1");
        return personRepository.findById(personID).get();
    }
    @Override
    public List<Person> getAllPeople(){
//        Person[] persons = {new Person("1", "John Doe", "XXXX","Address 1"),
//                new Person("2", "Jane Doe", "YYYY","Address 2")};
//        return Arrays.asList(persons);
        return personRepository.findAll();
    }

    @Override
    public String addHobbyToPerson(String personID, Hobby hobby) {
        Person person = personRepository.findById(personID).orElseThrow();
        hobby.setPerson(person);
        person.getHobbies().add(hobby);
        personRepository.save(person);
        return "Success";
    }

    @Override
    public List<Hobby> getHobbiesForPerson(String personID) {
        Person person = personRepository.findById(personID).orElseThrow();
        return person.getHobbies();
    }

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

    @Override
    public String deleteHobbyFromPerson(String personID, String hobbyID) {
        Person person = personRepository.findById(personID).orElseThrow();
        person.getHobbies().removeIf(hobby -> hobby.getHobbyID().equals(hobbyID));
        personRepository.save(person);
        return "Success";
    }
}
