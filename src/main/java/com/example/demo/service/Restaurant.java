package com.example.demo.service;


import com.example.demo.exception.RestaurantException;
import org.springframework.stereotype.Service;


public interface Restaurant {
    String restaurantName() throws RestaurantException;
}
