package com.niit.AdminProfile.controller;

import com.niit.AdminProfile.exception.DataPresentInAddToFavourite;
import com.niit.AdminProfile.model.AddFavourite;
import com.niit.AdminProfile.model.AddToCart;
import com.niit.AdminProfile.service.AddToCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addToCart")
public class AddToCartController
{
    @Autowired
    AddToCartService addToCartService;

    @PostMapping("/post")
    ResponseEntity<?> addToCart(@RequestBody AddToCart addToCart) throws Exception
    {
        return new ResponseEntity<>(addToCartService.addToCart(addToCart), HttpStatus.CREATED);
    }
    @GetMapping("/get/{email}")
    ResponseEntity<?> getAllCart(@PathVariable String email)
    {
        return new ResponseEntity<>(addToCartService.getAll(email),HttpStatus.OK);
    }

    @DeleteMapping("/delete/cart/{uemailid}/{emailid}/{dishName}")
    ResponseEntity<?> deletefromcart(@PathVariable String uemailid,@PathVariable String emailid,@PathVariable String dishName)
    {
        return new ResponseEntity<>(addToCartService.deleteToCart(uemailid,emailid,dishName),HttpStatus.OK);
    }
}
