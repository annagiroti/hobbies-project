package com.hobbiesproject.person_api.service;

import com.hobbiesproject.person_api.api.model.Hobby;

import java.util.List;

/**
 * Service interface for managing Hobby-related business logic
 * Defines the contract for operations that can be performed on hobbies
 */
public interface HobbyService {

    // Create a new hobby
    public String createHobby(Hobby hobby);

    // Update an existing hobby
    public String updateHobby(Hobby hobby);

    // Delete an existing hobby by its ID
    public String deleteHobby(String hobbyID);

    // Read an existing hobby by its ID
    public Hobby getHobby(String hobbyID);

    // Read all hobbies
    public List<Hobby> getAllHobbies();

}
