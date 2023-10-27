package com.niit.AdminProfile.controller;

import com.niit.AdminProfile.exception.RestaurantAlreadyExistException;
import com.niit.AdminProfile.model.Restaurant;
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
@RequestMapping("/admin")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

//    @PostMapping("/addrestaurant")
//    public ResponseEntity<?>  addRestaurantDeatils(@RequestBody Restaurant restaurant) throws RestaurantAlreadyExistException{
//
//        return new ResponseEntity<>(restaurantService.addRestaurantDetails(restaurant), HttpStatus.CREATED);
//    }

    @PostMapping("/addrestaurant")
    public ResponseEntity<?> signup(@RequestPart("profile") Restaurant restaurant, @RequestPart("imageFile") MultipartFile file ) throws IOException, RestaurantAlreadyExistException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Path currentPath = Paths.get("AdminProfile");
        Path absolutePath = currentPath.toAbsolutePath();
        Restaurant profile=new Restaurant();
        profile.setImageUrl(absolutePath + "/src/main/resources/restaurant/");
        byte[] bytes = file.getBytes();
        Path path = Paths.get(profile.getImageUrl() + file.getOriginalFilename());
        Files.write(path, bytes);
        Restaurant restaurant1=new Restaurant(restaurant.getEmailid(),restaurant.getResturantName(), restaurant.getCity(), restaurant.getPincode(), restaurant.getRating(), profile.getImageUrl()+file.getOriginalFilename(), file.getBytes());
        return new ResponseEntity<>(restaurantService.addRestaurantDetails(restaurant1), HttpStatus.CREATED);
    }


    @DeleteMapping("/removerestaurant/{emailid}")
    public ResponseEntity<?> removeRestaurantDetails(@PathVariable String emailid){
        return new ResponseEntity<>(restaurantService.removeRestaurantDetails(emailid),HttpStatus.OK);
    }

    @GetMapping("/getrestaurant")
    public ResponseEntity<?> getrestaurant(){
        return new ResponseEntity<>(restaurantService.getRestaurant(),HttpStatus.OK);
    }

    @GetMapping("/search/{restName}")
    public ResponseEntity<?> searchRestaurant(@PathVariable String restName)
    {
        return new ResponseEntity<>(restaurantService.searchRestaurant(restName),HttpStatus.OK);
    }

    @GetMapping("/searchbycity/{city}")
    public ResponseEntity<?> searchRestaurantByCity(@PathVariable String city)
    {
        return new ResponseEntity<>(restaurantService.searchCity(city),HttpStatus.OK);
    }
}