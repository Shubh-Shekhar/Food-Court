package com.niit.AdminProfile.repository;


import com.niit.AdminProfile.model.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,String>
{
public List<Restaurant> findByResturantName(String resturantName);
    public List<Restaurant> findByCity(String city);
}
