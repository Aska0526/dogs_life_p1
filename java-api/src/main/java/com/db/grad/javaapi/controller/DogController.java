package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.db.grad.javaapi.model.Dog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    DogService dogService;

    @GetMapping("/dogs/")
    public List<Dog> getAllDogs(){
        return dogService.getAllDogs();
    }

    @GetMapping("/dogs/{id}")
    public Dog getDogBySpecificID(@PathVariable long id){
        return dogService.getDogById(id);
    }

    @GetMapping("/dogs/count")
    public long getNoOfDogsInDb(){
        return dogService.getNoOfDogs();
    }
}
