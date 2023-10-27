package com.niit.AdminProfile.service;

import com.niit.AdminProfile.exception.RestaurantAlreadyExistException;
import com.niit.AdminProfile.model.Restaurant;
import com.niit.AdminProfile.repository.RestaurantRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestaurantServiceTest {
    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantServiceImpl restaurantServiceImpl;

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
    public void addRestaurentDetails() throws RestaurantAlreadyExistException {

        when(restaurantRepository.findById(restaurant.getEmailid())).thenReturn(Optional.ofNullable(null));
        when(restaurantRepository.save(restaurant)).thenReturn(restaurant);
        assertEquals(restaurant,restaurantServiceImpl.addRestaurantDetails(restaurant));
//        verify(restaurantRepository,times(1)).findById(restaurant.getEmailid());
//        verify(restaurantRepository,times(1)).insert(restaurant);
    }

    @Test
    public void addRestaurentDetailsWithException() throws RestaurantAlreadyExistException
    {
        when(restaurantRepository.findById(restaurant.getEmailid())).thenReturn(Optional.ofNullable(restaurant));
        assertThrows(RestaurantAlreadyExistException.class,()->restaurantServiceImpl.addRestaurantDetails(restaurant));
        verify(restaurantRepository,times(1)).findById(restaurant.getEmailid());
        verify(restaurantRepository,times(0)).insert(restaurant);
    }

    @Test
    public void deleteRestaurentData(){
        when(restaurantRepository.findById(restaurant.getEmailid())).thenReturn(Optional.ofNullable(restaurant));
        boolean data=restaurantServiceImpl.removeRestaurantDetails(restaurant.getEmailid());
        assertEquals(true,data);
        verify(restaurantRepository,times(1)).findById(restaurant.getEmailid());
        verify(restaurantRepository,times(1)).deleteById(restaurant.getEmailid());

    }

}
