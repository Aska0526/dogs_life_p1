package com.example.superheroes.service;

import com.example.superheroes.model.Hero;
import com.example.superheroes.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class HeroService {
    @Autowired
    HeroRepository heroRepo;

    public List<Hero> getHeroStartingWithLetter(String string) {
        return heroRepo.findHeroesNameStartingWithStr(string + "%");
    }

    public List<Hero> getAllHeroes() {
        return heroRepo.findAll();
    }

    public List<Hero> getTop3ByOrderByNameDesc() {
        return heroRepo.findTop3ByOrderByNameDesc();
    }

    public Hero saveHero(Hero hero) {
        return heroRepo.save(hero);
    }
}
