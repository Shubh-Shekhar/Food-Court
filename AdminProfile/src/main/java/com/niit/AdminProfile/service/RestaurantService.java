package com.niit.AdminProfile.service;


import com.niit.AdminProfile.exception.RestaurantAlreadyExistException;
import com.niit.AdminProfile.model.Restaurant;

import java.util.List;

public interface RestaurantService
{
    public abstract Restaurant addRestaurantDetails (Restaurant restaurant) throws RestaurantAlreadyExistException;
    public abstract boolean removeRestaurantDetails(String emailid);

    public abstract List<Restaurant> getRestaurant();

    public abstract List<Restaurant> searchRestaurant(String resturantName);
    public abstract List<Restaurant> searchCity(String city);
}
