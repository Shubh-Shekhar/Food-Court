package com.niit.AdminProfile.service;

import com.niit.AdminProfile.exception.RestaurentMenuAlradyPresent;
import com.niit.AdminProfile.model.RestaurantMenu;
import com.niit.AdminProfile.repository.RestaurantMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantMenuServiceImpl implements RestaurantMenuService{

    @Autowired
    RestaurantMenuRepository restaurantMenuRepository;

    @Override
    public RestaurantMenu addDishesDetails(RestaurantMenu restaurantMenu) throws RestaurentMenuAlradyPresent {
        RestaurantMenu restaurantMenu1=restaurantMenuRepository.findByEmailidAndDishName(restaurantMenu.getEmailid(), restaurantMenu.getDishName());
        if(restaurantMenu1!=null)
        {
            throw new RestaurentMenuAlradyPresent();

        }
        else {
            return restaurantMenuRepository.save(restaurantMenu);
        }
    }

    @Override
    public RestaurantMenu updateDishesDetails(RestaurantMenu restaurantMenu) throws Exception {
        return null;
    }

    @Override
    public boolean removeDishes(String emailid, String dishName) throws Exception {
        RestaurantMenu restaurantMenu=restaurantMenuRepository.findByEmailidAndDishName(emailid,dishName);
        if(restaurantMenu==null)
        {
            throw new Exception();

        }
        else {
            restaurantMenuRepository.deleteByEmailidAndDishName(emailid,dishName);
             return true;
        }

    }

    @Override
    public List<RestaurantMenu> getDishes(String emailid) {

        return restaurantMenuRepository.findByEmailid(emailid);

    }

    @Override
    public List<RestaurantMenu> getAllDishes() {
        return restaurantMenuRepository.findAll();
    }

    @Override
    public List<RestaurantMenu> searchDishes(String dishName) {
        return restaurantMenuRepository.findByDishName(dishName);
    }
}
