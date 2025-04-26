package com.hobbiesproject.person_api.service.impl;

import com.hobbiesproject.person_api.api.model.Hobby;
import com.hobbiesproject.person_api.repository.HobbyRepository;
import com.hobbiesproject.person_api.service.HobbyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService {
    HobbyRepository hobbyRepository;

    public HobbyServiceImpl(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    @Override
    public String createHobby(Hobby hobby){
        hobbyRepository.save(hobby);
        return "Success";
    }
    @Override
    public String updateHobby(Hobby hobby){
        hobbyRepository.save(hobby);
        return "Success";
    }
    @Override
    public String deleteHobby(String hobbyID){
        hobbyRepository.deleteById(hobbyID);
        return "Success";
    }
    @Override
    public Hobby getHobby(String hobbyID){
        return hobbyRepository.findById(hobbyID).get();
    }
    @Override
    public List<Hobby> getAllHobbies(){
        return hobbyRepository.findAll();
    }
}
