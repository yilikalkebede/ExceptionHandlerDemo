package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Qualifier("Pizza")
public class PizzaRestaurant implements Restaurant{
    @Override
    public String restaurantName() {
        return "Hello, I am a Pizza Restaurant";
    }
}
