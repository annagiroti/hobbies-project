package com.hobbiesproject.person_api.service;

import com.hobbiesproject.person_api.api.model.Hobby;

import java.util.List;

public interface HobbyService {
    public String createHobby(Hobby hobby);
    public String updateHobby(Hobby hobby);
    public String deleteHobby(String hobbyID);
    public Hobby getHobby(String hobbyID);
    public List<Hobby> getAllHobbies();

}
