package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;

import java.util.ArrayList;
import java.util.List;

public class DogHandler {

    private DogsRepository itsDogRepo;
    public DogHandler(DogsRepository repo) {
        itsDogRepo = repo;
    }

    public Long addDog(Dog theDog) {
        return itsDogRepo.save(theDog);
    }

    public long getNoOfDogs() {
        return itsDogRepo.count();
    }


    public Dog getDogByName(String name) {
        Dog dog = new Dog();
        dog.setName(name);
        List<Dog> list = itsDogRepo.findByName(dog);

        if (list.size() != 1) {
            return null;
        }

        return list.get(0);
    }
}
