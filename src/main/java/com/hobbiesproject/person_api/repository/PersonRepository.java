package com.hobbiesproject.person_api.repository;

import com.hobbiesproject.person_api.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
