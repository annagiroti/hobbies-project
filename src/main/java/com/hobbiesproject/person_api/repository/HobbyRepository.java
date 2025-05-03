package com.hobbiesproject.person_api.repository;

import com.hobbiesproject.person_api.api.model.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Hobby entity
 * Extends JpaRepository to provide CRUD operations and query methods
 */
public interface HobbyRepository extends JpaRepository<Hobby, String> {
}
