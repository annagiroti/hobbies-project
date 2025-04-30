package com.hobbiesproject.person_api.repository;

import com.hobbiesproject.person_api.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    List<Person> findByHobbies_HobbyName(String hobbyName);
}
