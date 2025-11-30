package com.delivery.delivery_service.controller;

import com.delivery.delivery_service.model.MenuItem;
import com.delivery.delivery_service.repository.MenuItemRepository;
import com.delivery.delivery_service.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/restaurants/{restaurantId}/menuitems")
public class MenuItemController {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuItemController(MenuItemRepository menuItemRepository, RestaurantRepository restaurantRepository) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }


    @GetMapping
    public ResponseEntity<List<MenuItem>> getMenuItemsByRestaurant(@PathVariable Long restaurantId) {
        if (!restaurantRepository.existsById(restaurantId)) {
            return ResponseEntity.notFound().build();
        }
        List<MenuItem> menuItems = menuItemRepository.findByRestaurantId(restaurantId);
        return ResponseEntity.ok(menuItems);
    }

    @PostMapping
    public ResponseEntity<MenuItem> createMenuItem(@PathVariable Long restaurantId, @RequestBody MenuItem menuItem) {
        return restaurantRepository.findById(restaurantId).map(restaurant -> {
            menuItem.setRestaurantId(restaurant.getId());
            MenuItem savedMenuItem = menuItemRepository.save(menuItem);
            return new ResponseEntity<>(savedMenuItem, HttpStatus.CREATED);
        }).orElse(ResponseEntity.notFound().build());
    }
}
