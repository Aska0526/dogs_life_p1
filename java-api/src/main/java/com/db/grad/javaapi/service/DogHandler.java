package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exceptions.DogNotFoundException;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
  
    public Dog getDogById(long uniqueID) {
        return itsDogRepo.findById(uniqueID);
    }
  
    public boolean removeDog(long id){
        if(itsDogRepo.findById(id) != null){
            return itsDogRepo.delete(itsDogRepo.findById(id));
        }
       return false;
    }
  
    public long updateDogDetails(Dog theDog) {
        if (itsDogRepo.findById(theDog.getId()) != null) {
            return itsDogRepo.save(theDog);
        } else {
            throw new DogNotFoundException();
        }
    }
}
