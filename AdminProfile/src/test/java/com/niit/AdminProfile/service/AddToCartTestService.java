package com.niit.AdminProfile.service;

import com.niit.AdminProfile.model.AddToCart;
import com.niit.AdminProfile.model.RestaurantMenu;
import com.niit.AdminProfile.repository.AddToCartRepository;
import com.niit.AdminProfile.repository.AddToCartTestRepository;
import com.niit.AdminProfile.repository.RestaurantMenuRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddToCartTestService {
    @Mock
    private AddToCartRepository addToCartRepository;

    @InjectMocks
    private AddToCartServiceImpl addToCartServiceImpl;

    private AddToCart addToCart;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte [] data = bos.toByteArray();
        addToCart=new AddToCart("rest@.com","my rest","panir tikka","1","350","masala panir fry",data,"user@.com");
    }

    @AfterEach
    public void distroy()
    {
        addToCart=null;
        addToCartRepository.deleteAll();
    }

    @Test
    public void addToCartDetails() throws Exception {

        when(addToCartRepository.findByUemailidAndEmailidAndDishName(addToCart.getUemailid(),addToCart.getEmailid(),addToCart.getDishName())).thenReturn(null);
        when(addToCartRepository.save(addToCart)).thenReturn(addToCart);
        assertEquals(addToCart,addToCartServiceImpl.addToCart(addToCart));
//        verify(restaurantRepository,times(1)).findById(restaurant.getEmailid());
//        verify(restaurantRepository,times(1)).insert(restaurant);
    }


}
