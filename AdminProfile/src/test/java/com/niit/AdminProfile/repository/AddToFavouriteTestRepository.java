package com.niit.AdminProfile.repository;

import com.niit.AdminProfile.model.AddFavourite;
import com.niit.AdminProfile.model.AddToCart;
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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class AddToFavouriteTestRepository {

    @Autowired
    private AddFavouriteRepository addFavouriteRepository;

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
    public void givenAddToCartDetailsToSaveReturnAddToCart()
    {
        addFavouriteRepository.insert(addFavourite);
        AddFavourite data=addFavouriteRepository.findByUemailidAndEmailidAndDishName(addFavourite.getUemailid(),addFavourite.getEmailid(),addFavourite.getDishName());
        assertEquals(data.getEmailid(),addFavourite.getEmailid());
    }

    @Test
    public void getAllAddToCartDetails()
    {
        addFavouriteRepository.save(addFavourite);
        List<AddFavourite> data=addFavouriteRepository.findAll();
        assertEquals(1,data.size());
    }

    @Test
    public void deleteFromAddToCart()
    {
        addFavouriteRepository.insert(addFavourite);
        addFavouriteRepository.deleteByRestaurantNameAndDishName(addFavourite.getRestaurantName(),addFavourite.getDishName());
        assertEquals(Optional.empty(),addFavouriteRepository.findById(addFavourite.getDishName()));
    }

//    @Test
//    public void testingForFailureWithSameEntriesTwice() throws DuplicateKeyException {
//        addFavouriteRepository.insert(addFavourite);
//        assertThrows(DuplicateKeyException.class,()-> addFavouriteRepository.insert(addFavourite));
//    }
}
