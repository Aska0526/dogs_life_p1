package com.db.grad.javaapi.service;

import com.db.grad.javaapi.exceptions.DogNotFoundException;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.DogsRepository;
import com.db.grad.javaapi.repository.DogsRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DogHandlerTest {

    private final DogsRepository itsDogRepo = new DogsRepositoryStub();

    @BeforeEach
    public void makeSureRepoIsEmpty() {
        itsDogRepo.deleteAll();
    }

    @Test
    public void add_a_dog_return_number_of_dogs_in_repo_is_one() {

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        int expectedResult = 1;

        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void add_several_dog_return_number_of_dogs_match_number_added() {

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        final int NOFDOGS = 3;
        for (int i = 0; i < NOFDOGS; i++) {
            Dog theDog = new Dog();
            theDog.setName("Bruno" + i);
            cut.addDog(theDog);
        }

        long actualResult = cut.getNoOfDogs();

        //assert
        assertEquals(NOFDOGS, actualResult);
    }

    @Test
    public void remove_dog_and_return_true_if_removed(){

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        Long idOfTheDog = cut.addDog(theDog);

        boolean actualResult = cut.removeDog(idOfTheDog);

        boolean expectedResult = true;

        //assert

        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void remove_dog_that_is_not_in_db_return_false(){

        //arrange
        DogHandler cut = new DogHandler(itsDogRepo);

        //act
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        Long idOfTheDog = cut.addDog(theDog);

        long noOfDogs = cut.getNoOfDogs();
        boolean actualResult = cut.removeDog(noOfDogs+1);
        boolean expectedResult = false;

        assertEquals(actualResult,expectedResult);

    }

    @Test
    public void update_dog_that_exists_returns_dog_id() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        long expectedId = cut.addDog(theDog);
        theDog.setName("NotBruno");

        long actualId = cut.updateDogDetails(theDog);

        assertEquals(expectedId, actualId);
    }

    @Test
    public void find_dog_by_id_returns_dog(){

        DogHandler cut = new DogHandler(itsDogRepo);

        Dog theDog = new Dog();
        theDog.setName("Bruce");
        cut.addDog(theDog);
        theDog = new Dog();
        theDog.setName("Clark");
        long uniqueID = cut.addDog(theDog);
        Dog expectedDog = theDog;
        theDog = new Dog();
        theDog.setName("Diana");
        cut.addDog(theDog);

        Dog actualResult = cut.getDogById(uniqueID);

        assertEquals(expectedDog.getId(),actualResult.getId());
        assertEquals(expectedDog.getName(),actualResult.getName());

    }

    @Test
    public void find_dog_by_wrong_id_returns_null(){

        DogHandler cut = new DogHandler(itsDogRepo);

        //make sure repo has at least one dog
        Dog theDog = new Dog();
        theDog.setName("Bruce");
        cut.addDog(theDog);

        //use a wrong id
        Dog actualResult = cut.getDogById(88564);

        assertNull(actualResult);

    }

    @Test
    public void find_Dog_by_Name_If_only_exist() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog exist = new Dog();
        exist.setName("Bruno");
        long id = cut.addDog(exist);

        exist = cut.getDogByName(exist.getName());

        assertEquals("Bruno", exist.getName());
        assertEquals(id, exist.getId());
    }

    @Test
    public void find_Dog_by_Name_If_No_dog_has_such_name() {
        DogHandler cut = new DogHandler(itsDogRepo);

        Dog exist = new Dog();
        exist.setName("Bruno");
        cut.addDog(exist);

        exist = cut.getDogByName("John");

        assertNull(exist);
    }

    @Test
    public void update_dog_that_not_exists_throws() {
        DogHandler cut = new DogHandler(itsDogRepo);
        Dog theDog = new Dog();
        theDog.setName("Bruno");
        cut.addDog(theDog);
        Dog theSecondDog = new Dog();
        theSecondDog.setName("NotBruno");

        assertThrows(DogNotFoundException.class, () -> cut.updateDogDetails(theSecondDog));
    }
}
