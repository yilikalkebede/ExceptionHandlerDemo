package com.example.demo.service;

import com.example.demo.exception.RestaurantException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("Burger")
public class BurgerRestaurant implements Restaurant{
    @Override
    public String restaurantName() throws RestaurantException {
        try {
            String name = null;
            name.length();
        }catch (NullPointerException e){
            var restaurantException = new RestaurantException(e.getMessage());
            throw restaurantException;
        }

        return "Hello, I am a Burger Restaurant";
    }
}
