package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {

    @Autowired
    DogService dogService;

    @GetMapping("/dogs/{id}")
    public Dog getDogBySpecificID(long id){
        return dogService.getDogById(id);
    }
}
