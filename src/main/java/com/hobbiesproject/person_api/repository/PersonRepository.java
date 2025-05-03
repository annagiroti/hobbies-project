package com.hobbiesproject.person_api.repository;

import com.hobbiesproject.person_api.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for Person entity
 * Extends JpaRepository to provide CRUD operations and query methods
 */
public interface PersonRepository extends JpaRepository<Person, String> {
    // Custom query method to find all people who have a hobby with the given name
    List<Person> findByHobbies_HobbyName(String hobbyName);
}
