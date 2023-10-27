package com.niit.AdminProfile.service;

import com.niit.AdminProfile.exception.DataPresentInAddToFavourite;
import com.niit.AdminProfile.model.AddFavourite;
import com.niit.AdminProfile.model.AddToCart;
import com.niit.AdminProfile.repository.AddFavouriteRepository;
import com.niit.AdminProfile.repository.AddToCartRepository;
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
public class AddToFavouriteTestService {
    @Mock
    private AddFavouriteRepository addFavouriteRepository;

    @InjectMocks
    private AddFavouriteServiceImpl addFavouriteServiceImpl;

    private AddFavourite addFavourite;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte [] data = bos.toByteArray();
        addFavourite=new AddFavourite("rest@.com","my rest","panir tikka","1","350","masala panir fry",data,"user@.com");
    }

    @AfterEach
    public void distroy()
    {
        addFavourite=null;
        addFavouriteRepository.deleteAll();
    }

    @Test
    public void addToFavouriteDetails() throws DataPresentInAddToFavourite {

        when(addFavouriteRepository.findByUemailidAndEmailidAndDishName(addFavourite.getUemailid(),addFavourite.getEmailid(),addFavourite.getDishName())).thenReturn(null);
        when(addFavouriteRepository.save(addFavourite)).thenReturn(addFavourite);
        assertEquals(addFavourite,addFavouriteServiceImpl.addToFavourite(addFavourite));
//        verify(restaurantRepository,times(1)).findById(restaurant.getEmailid());
//        verify(restaurantRepository,times(1)).insert(restaurant);
    }


}
