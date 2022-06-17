package com.example.demo.controller;

import com.example.demo.exception.RestaurantException;
import com.example.demo.service.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RestaurantController {

    @Autowired
    @Qualifier("Burger")
    Restaurant restaurant;

    @Autowired
    Restaurant restaurant2;

    @GetMapping("/hello")
    public ResponseEntity<String> restaurantName() throws RestaurantException {
        try{
            var name = restaurant.restaurantName()+ "  " +restaurant2.restaurantName();
            return ResponseEntity.status(HttpStatus.OK).body(name);
        }catch (RestaurantException exception){
            log.info("Exception occurred {}", exception.getMessage());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Contact your Admin");
            throw exception;
        }

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({RestaurantException.class})
    public String handlingException(){

        return "there is an exception";
    }
}
