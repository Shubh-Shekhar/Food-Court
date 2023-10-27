package com.niit.AdminProfile.repository;

import com.niit.AdminProfile.exception.RestaurantAlreadyExistException;
import com.niit.AdminProfile.model.Restaurant;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class RestaurantTestRepository {
    @Autowired
    private RestaurantRepository restaurantRepository;

    private Restaurant restaurant;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        byte [] data = bos.toByteArray();
        restaurant=new Restaurant("restaurant@.com","my Rest","mumbai","4000067","4.5","c//data//asdf.jpg",data);

    }

    @AfterEach
    public void distroy()
    {
        restaurant=null;
        restaurantRepository.deleteAll();
    }

    @Test
    public void givenRestaurantDetailsToSaveReturnRestaurant()
    {
        restaurantRepository.insert(restaurant);
        Restaurant data=restaurantRepository.findById(restaurant.getEmailid()).get();
        assertEquals(data.getEmailid(),restaurant.getEmailid());
    }

    @Test
    public void getAllRestaurant()
    {
        restaurantRepository.insert(restaurant);
        List<Restaurant> data=restaurantRepository.findAll();
        assertEquals(1,data.size());
    }

    @Test
    public void deleteRestaurantByEmailId()
    {
        restaurantRepository.insert(restaurant);
        restaurantRepository.deleteById(restaurant.getEmailid());
        assertEquals(Optional.empty(),restaurantRepository.findById(restaurant.getEmailid()));
    }

    @Test
    public void saveRestaurantWithException() throws RestaurantAlreadyExistException
    {
        restaurantRepository.insert(restaurant);
//        Product data=productRespository.findById(product.getPid()).get();
        assertThrows(Exception.class,()->restaurantRepository.insert(restaurant));
    }


    @Test
    public void testingForFailureWithSameEntriesTwice() throws DuplicateKeyException {
        restaurantRepository.insert(restaurant);
        assertThrows(DuplicateKeyException.class,()-> restaurantRepository.insert(restaurant));
    }
}
