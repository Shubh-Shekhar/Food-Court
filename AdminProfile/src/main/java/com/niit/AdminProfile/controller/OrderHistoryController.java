package com.niit.AdminProfile.controller;

import com.niit.AdminProfile.model.AddToCart;
import com.niit.AdminProfile.model.OrderHistory;
import com.niit.AdminProfile.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderHistory")
public class OrderHistoryController {
    @Autowired
    OrderHistoryService orderHistoryService;

    @PostMapping("/post")
    ResponseEntity<?> addToCart(@RequestBody OrderHistory orderHistory)
    {
        return new ResponseEntity<>(orderHistoryService.orderHistory(orderHistory), HttpStatus.CREATED);
    }

    @GetMapping("/get/{uemailid}")
    ResponseEntity<?> getAllCart(@PathVariable String uemailid)
    {
        return new ResponseEntity<>(orderHistoryService.getAll(uemailid),HttpStatus.OK);
    }



}
