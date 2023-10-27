package com.niit.AdminProfile.repository;

import com.niit.AdminProfile.model.RestaurantMenu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RestaurantMenuRepository extends MongoRepository<RestaurantMenu,String> {

public RestaurantMenu findByEmailidAndDishName(String emailid,String dishName);
public List<RestaurantMenu> findByEmailid(String emailid);

public void deleteByEmailidAndDishName(String emailid, String dishName);

    public List<RestaurantMenu> findByDishName(String dishName);
}

