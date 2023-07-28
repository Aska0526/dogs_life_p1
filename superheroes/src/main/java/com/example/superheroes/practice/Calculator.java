package com.example.superheroes.practice;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public int addition(int nr1, int nr2) {
        return nr1 + nr2;
    }

    @PostConstruct
    public void init() {
        System.out.println("Calculator object has been created");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Calculator object has been destroyed");
    }
}
