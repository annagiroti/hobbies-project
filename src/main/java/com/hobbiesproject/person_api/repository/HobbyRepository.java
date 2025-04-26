package com.hobbiesproject.person_api.repository;

import  com.hobbiesproject.person_api.api.model.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyRepository extends JpaRepository<Hobby, String> {
}
