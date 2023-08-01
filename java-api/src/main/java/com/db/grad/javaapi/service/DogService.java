package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exceptions.DogNotFoundException;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {


    @Autowired
    private DogsRepository itsDogRepo;

    public DogService(DogsRepository repo) {
        itsDogRepo = repo;
    }

    public List<Dog> getAllDogs() {
        return itsDogRepo.findAll();
    }

    public Dog addDog(Dog theDog) {
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
  
    public void removeDog(long id){
        if(itsDogRepo.findById(id) != null){
            itsDogRepo.delete(itsDogRepo.findById(id));
        }
    }
  
    public Dog updateDogDetails(Dog theDog) {
        if (itsDogRepo.findById(theDog.getId()) != null) {
            return itsDogRepo.save(theDog);
        } else {
            throw new DogNotFoundException();
        }
    }
}
