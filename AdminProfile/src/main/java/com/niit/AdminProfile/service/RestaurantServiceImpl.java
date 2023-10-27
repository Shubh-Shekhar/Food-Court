package com.niit.AdminProfile.service;

import com.niit.AdminProfile.exception.RestaurantAlreadyExistException;
import com.niit.AdminProfile.model.Restaurant;
import com.niit.AdminProfile.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    @Override
    public Restaurant addRestaurantDetails(Restaurant restaurant) throws RestaurantAlreadyExistException {
       if(restaurantRepository.findById(restaurant.getEmailid()).isPresent()){
            throw new RestaurantAlreadyExistException();
       }
       else{
           return restaurantRepository.save(restaurant);
       }

    }

    @Override
    public boolean removeRestaurantDetails(String emailid) {
        if(restaurantRepository.findById(emailid).isPresent()){
            restaurantRepository.deleteById(emailid);
            return true;
        }
        else {
            return false;

        }
    }

    @Override
    public List<Restaurant> getRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String resturantName) {
        return restaurantRepository.findByResturantName(resturantName);
    }

    @Override
    public List<Restaurant> searchCity(String city) {
        return restaurantRepository.findByCity(city);
    }
}
