package com.niit.AdminProfile.controller;

import com.niit.AdminProfile.exception.RestaurantAlreadyExistException;
import com.niit.AdminProfile.model.Restaurant;
import com.niit.AdminProfile.model.RestaurantMenu;
import com.niit.AdminProfile.service.RestaurantMenuService;
import com.niit.AdminProfile.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/admin/menu")
public class RestaurantMenuController {

    @Autowired
    RestaurantMenuService restaurantMenuService;


    @PostMapping("/addDetails")
    public ResponseEntity<?> signup(@RequestPart("profile") RestaurantMenu restaurant, @RequestPart("imageFile") MultipartFile file ) throws Exception {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        RestaurantMenu restaurantMenu=new RestaurantMenu(restaurant.getEmailid(), restaurant.getRestaurantName(), restaurant.getDishName(), restaurant.getQuantity(), restaurant.getPrice(), restaurant.getDescription(), file.getBytes());
        return new ResponseEntity<>(restaurantMenuService.addDishesDetails(restaurantMenu), HttpStatus.CREATED);
    }

    @GetMapping("/getProducts/{emailid}")
    public ResponseEntity<?> getAll(@PathVariable String emailid){
        return new ResponseEntity<>(restaurantMenuService.getDishes(emailid),HttpStatus.OK);
    }

    @GetMapping("/getProducts")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(restaurantMenuService.getAllDishes(),HttpStatus.OK);
    }

    @DeleteMapping("/deletedish/{emailid}/{dish}")
    public ResponseEntity<?> delete(@PathVariable String emailid,@PathVariable String dish) throws Exception {
        return new ResponseEntity<>(restaurantMenuService.removeDishes(emailid,dish),HttpStatus.OK);
    }

    @GetMapping("/searchbydishname/{dishName}")
    public ResponseEntity<?> searchDishes(@PathVariable String dishName){
        return new ResponseEntity<>(restaurantMenuService.searchDishes(dishName),HttpStatus.OK);
    }
}
