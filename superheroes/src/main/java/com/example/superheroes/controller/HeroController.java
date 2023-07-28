package com.example.superheroes.controller;

import com.example.superheroes.model.Hero;
import com.example.superheroes.service.HeroService;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

    @Autowired
    HeroService heroService;

    @GetMapping("/heroes")
    public List<Hero> getAllHeroes(){
        return heroService.getAllHeroes();
    }

    @GetMapping("/heroes/{letter}")
    public List<Hero> getHeroesStartingWithLetter(@PathVariable String letter){
        return heroService.getHeroesStartingWithLetter(letter);
    }

    @PostMapping("/heroes")
    public HttpStatus saveHero(@RequestBody Hero heroToBeSaved){
        if (heroService.saveHero(heroToBeSaved) == null)
            return HttpStatus.PRECONDITION_FAILED;
        return HttpStatus.CREATED;
    }
}
