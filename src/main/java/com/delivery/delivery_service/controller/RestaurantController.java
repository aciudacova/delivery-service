package com.delivery.delivery_service.controller;

import com.delivery.delivery_service.model.Restaurant;
import com.delivery.delivery_service.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        return restaurantRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurantDetails) {
        return restaurantRepository.findById(id)
                .map(existingRestaurant -> {
                    existingRestaurant.setName(restaurantDetails.getName());
                    existingRestaurant.setAddress(restaurantDetails.getAddress());
                    existingRestaurant.setCuisineType(restaurantDetails.getCuisineType());
                    existingRestaurant.setRating(restaurantDetails.getRating());
                    existingRestaurant.setOperatingHours(restaurantDetails.getOperatingHours());
                    Restaurant updatedRestaurant = restaurantRepository.save(existingRestaurant);
                    return ResponseEntity.ok(updatedRestaurant);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
