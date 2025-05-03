package com.hobbiesproject.person_api.api.controller;

import com.hobbiesproject.person_api.api.model.Hobby;
import com.hobbiesproject.person_api.service.HobbyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller to manage Hobby-related operations
 */
@RestController
@RequestMapping("/hobby")
public class HobbyController {

    HobbyService hobbyService;

    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    // Read specific hobby details by its ID
    @GetMapping("/{hobbyID}")
    public Hobby getHobbyDetails(@PathVariable("hobbyID") String hobbyID) {
        return hobbyService.getHobby(hobbyID);
    }

    // Read all hobby details
    @GetMapping()
    public List<Hobby> getAllHobbiesDetails() {
        return hobbyService.getAllHobbies();
    }

    // Create a new hobby
    @PostMapping()
    public String createHobbyDetails(@RequestBody Hobby hobby) {
        hobbyService.createHobby(hobby);
        return "Hobby created successfully";
    }

    // Update an existing hobby
    @PutMapping()
    public String updateHobbyDetails(@RequestBody Hobby hobby) {
        hobbyService.updateHobby(hobby);
        return "Hobby updated successfully";
    }

    // Delete a hobby by its ID
    @DeleteMapping("/{hobbyID}")
    public String deleteHobbyDetails(@PathVariable("hobbyID") String hobbyID) {
        hobbyService.deleteHobby(hobbyID);
        return "Hobby deleted successfully";
    }
}