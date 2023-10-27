package com.niit.AdminProfile.service;

import com.niit.AdminProfile.model.RestaurantMenu;

import java.util.List;

public interface RestaurantMenuService
{
    public abstract RestaurantMenu addDishesDetails (RestaurantMenu restaurantMenu) throws Exception;
    public abstract RestaurantMenu updateDishesDetails(RestaurantMenu restaurantMenu) throws Exception;
    public abstract boolean removeDishes(String emailid,String dishName) throws Exception;

    public abstract List<RestaurantMenu> getDishes(String emailid);
     List<RestaurantMenu> getAllDishes();
     List<RestaurantMenu> searchDishes(String dishName);
}
