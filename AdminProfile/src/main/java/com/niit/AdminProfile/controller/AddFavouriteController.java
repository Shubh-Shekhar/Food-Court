package com.niit.AdminProfile.controller;

import com.niit.AdminProfile.exception.DataPresentInAddToFavourite;
import com.niit.AdminProfile.model.AddFavourite;
import com.niit.AdminProfile.service.AddFavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addToFavourite")
public class AddFavouriteController {
    @Autowired
    AddFavouriteService addFavouriteService;

    @PostMapping("/post")
    ResponseEntity<?> addToFavourite(@RequestBody AddFavourite addFavourite) throws DataPresentInAddToFavourite
    {
        return new ResponseEntity<>(addFavouriteService.addToFavourite(addFavourite), HttpStatus.CREATED);
    }
    @GetMapping("/get/{email}")
    ResponseEntity<?> getAllFavourite(@PathVariable String email)
    {
        return new ResponseEntity<>(addFavouriteService.getAll(email),HttpStatus.OK);
    }

    @DeleteMapping("/delete/favourite/{uemailid}/{emailid}/{dishName}")
    ResponseEntity<?> deletefromfavourite(@PathVariable String uemailid,@PathVariable String emailid,@PathVariable String dishName)
    {
        return new ResponseEntity<>(addFavouriteService.deleteToFavourite(uemailid,emailid,dishName),HttpStatus.OK);
    }
}