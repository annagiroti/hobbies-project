package com.hobbiesproject.person_api.service.impl;

import com.hobbiesproject.person_api.api.model.Hobby;
import com.hobbiesproject.person_api.repository.HobbyRepository;
import com.hobbiesproject.person_api.service.HobbyService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the HobbyService interface
 * Contains the business logic for managing hobbies
 */
@Service
public class HobbyServiceImpl implements HobbyService {
    HobbyRepository hobbyRepository;

    public HobbyServiceImpl(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    // Create a new hobby for hobby database
    @Override
    public String createHobby(Hobby hobby) {
        hobbyRepository.save(hobby);
        return "Success";
    }

    // Update an existing hobby from hobby database
    @Override
    public String updateHobby(Hobby hobby) {
        hobbyRepository.save(hobby);
        return "Success";
    }

    // Delete a specific hobby from hobby database by its ID
    @Override
    public String deleteHobby(String hobbyID) {
        hobbyRepository.deleteById(hobbyID);
        return "Success";
    }

    // Read a specific hobby from hobby database by its ID
    @Override
    public Hobby getHobby(String hobbyID) {
        return hobbyRepository.findById(hobbyID).get();
    }

    // Read all hobbies from hobby database
    @Override
    public List<Hobby> getAllHobbies() {
        return hobbyRepository.findAll();
    }
}