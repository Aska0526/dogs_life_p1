package com.example.superheroes;

import com.example.superheroes.model.Hero;
import com.example.superheroes.practice.Calculator;
import com.example.superheroes.repository.HeroRepository;
import com.example.superheroes.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SuperheroesApplication implements CommandLineRunner {
	@Autowired
	HeroService heroService;

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Hero> heroes = heroService.getHeroesStartingWithLetter("C%");
		for (Hero hero: heroes){
			System.out.println(hero);
		}

		List<Hero> heroes2 = heroService.getAllHeroes();
		for (Hero hero: heroes2){
			System.out.println(hero);
		}

		List<Hero> heroes3 = heroService.getLastThreeHeroesByName();
		for (Hero hero: heroes3){
			System.out.println(hero);
		}

	}
}

