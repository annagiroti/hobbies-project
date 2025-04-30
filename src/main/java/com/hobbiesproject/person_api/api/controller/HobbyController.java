package com.hobbiesproject.person_api.api.controller;

import com.hobbiesproject.person_api.api.model.Hobby;
import com.hobbiesproject.person_api.service.HobbyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hobby")
public class HobbyController {
    HobbyService hobbyService;

    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }
    // Read specific hobby details from person database
    @GetMapping("/{hobbyID}")
    public Hobby getHobbyDetails(@PathVariable("hobbyID") String hobbyID) {
        return hobbyService.getHobby(hobbyID);
    }
    // Read all people details from person database
    @GetMapping()
    public List<Hobby> getAllHobbiesDetails() {
        return hobbyService.getAllHobbies();
    }

    @PostMapping()
    public String createHobbyDetails(@RequestBody Hobby hobby) {
        hobbyService.createHobby(hobby);
        return "Hobby created successfully";
    }

    @PutMapping()
    public String updateHobbyDetails(@RequestBody Hobby hobby) {
        hobbyService.updateHobby(hobby);
        return "Hobby updated successfully";
    }

    @DeleteMapping("/{hobbyID}")
    public String deleteHobbyDetails(@PathVariable("hobbyID") String hobbyID) {
        hobbyService.deleteHobby(hobbyID);
        return "Hobby deleted successfully";
    }
}