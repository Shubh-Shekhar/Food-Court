package com.niit.AdminProfile.repository;


import com.niit.AdminProfile.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantRepository extends MongoRepository<Restaurant,String>
{
public List<Restaurant> findByResturantName(String resturantName);
    public List<Restaurant> findByCity(String city);
}
