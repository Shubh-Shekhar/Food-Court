package com.niit.AdminProfile.service;

import com.niit.AdminProfile.exception.RestaurantAlreadyExistException;
import com.niit.AdminProfile.model.Restaurant;
import com.niit.AdminProfile.model.RestaurantMenu;
import com.niit.AdminProfile.repository.RestaurantMenuRepository;
import com.niit.AdminProfile.repository.RestaurantRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RestaurantMenuServiceTest {
    @Mock
    private RestaurantMenuRepository restaurantMenuRepository;

    @InjectMocks
    private RestaurantMenuServiceImpl restaurantMenuServiceImpl;

    private RestaurantMenu restaurantMenu;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte [] data = bos.toByteArray();
        restaurantMenu=new RestaurantMenu("rest@.com","my rest","panir tikka","1","350","masala panir fry",data);
    }
    @AfterEach
    public void distroy()
    {
        restaurantMenu=null;

        restaurantMenuRepository.deleteAll();
    }

    @Test
    public void addRestaurantMenuDetails() throws Exception {

        when(restaurantMenuRepository.findByEmailidAndDishName(restaurantMenu.getEmailid(),restaurantMenu.getDishName())).thenReturn(null);
        when(restaurantMenuRepository.save(restaurantMenu)).thenReturn(restaurantMenu);
        assertEquals(restaurantMenu,restaurantMenuServiceImpl.addDishesDetails(restaurantMenu));
//        verify(restaurantRepository,times(1)).findById(restaurant.getEmailid());
//        verify(restaurantRepository,times(1)).insert(restaurant);
    }

//    @Test
//    public void addRestaurantMenuDetailsWithException() throws Exception
//    {
//
//        when(restaurantMenuRepository.findById(restaurantMenu.getEmailid())).thenReturn(Optional.ofNullable(restaurantMenu));
//        assertThrows(Exception.class,()->restaurantMenuServiceImpl.addDishesDetails(restaurantMenu));
////        verify(restaurantMenuRepository,times(1)).findById(restaurantMenu.getEmailid());
////        verify(restaurantMenuRepository,times(0)).insert(restaurantMenu);
//    }

//    @Test
//    public void deleteRestaurantMenuData() throws Exception {
//        restaurantMenuRepository.save(restaurantMenu);
//        when(restaurantMenuRepository.findByEmailidAndDishName(restaurantMenu.getEmailid(),restaurantMenu.getDishName())).thenReturn((restaurantMenu));
//        boolean data=restaurantMenuRepository.deleteByEmailidAndDishName(restaurantMenu.getEmailid(), restaurantMenu.getDishName());
//        assertEquals(true,data);
////        verify(restaurantMenuRepository,times(1)).findById(restaurantMenu.getEmailid());
////        verify(restaurantMenuRepository,times(1)).deleteById(restaurantMenu.getEmailid());
//
//    }
}
