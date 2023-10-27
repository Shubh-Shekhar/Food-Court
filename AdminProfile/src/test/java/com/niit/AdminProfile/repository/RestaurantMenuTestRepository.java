package com.niit.AdminProfile.repository;

import com.niit.AdminProfile.model.Restaurant;
import com.niit.AdminProfile.model.RestaurantMenu;
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
public class RestaurantMenuTestRepository {

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

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
    public void givenRestaurantMenuDetailsToSaveReturnRestaurantMenu()
    {
        restaurantMenuRepository.insert(restaurantMenu);
        RestaurantMenu data=restaurantMenuRepository.findByEmailidAndDishName(restaurantMenu.getEmailid(),restaurantMenu.getDishName());
        assertEquals(data.getEmailid(),restaurantMenu.getEmailid());
    }

    @Test
    public void getAllRestaurantMenu()
    {
        restaurantMenuRepository.save(restaurantMenu);
        List<RestaurantMenu> data=restaurantMenuRepository.findAll();
        assertEquals(1,data.size());
    }

//    @Test
//    public void deleteRestaurantMenuByEmailId()
//    {
//        restaurantMenuRepository.insert(restaurantMenu);
//        restaurantMenuRepository.deleteById(restaurantMenu.getDishName());
//        assertEquals(Optional.empty(),restaurantMenuRepository.findById(restaurantMenu.getDishName()));
//    }
//
//    @Test
//    public void testingForFailureWithSameEntriesTwice() throws DuplicateKeyException {
//        restaurantMenuRepository.insert(restaurantMenu);
//        assertThrows(DuplicateKeyException.class,()-> restaurantMenuRepository.insert(restaurantMenu));
//    }

}
