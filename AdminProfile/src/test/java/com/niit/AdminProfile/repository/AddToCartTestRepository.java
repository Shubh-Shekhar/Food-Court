package com.niit.AdminProfile.repository;

import com.niit.AdminProfile.model.AddToCart;
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
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class AddToCartTestRepository {

    @Autowired
    private AddToCartRepository addToCartRepository;

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
    public void givenAddToCartDetailsToSaveReturnAddToCart()
    {
        addToCartRepository.insert(addToCart);
        AddToCart data=addToCartRepository.findByUemailidAndEmailidAndDishName(addToCart.getUemailid(),addToCart.getEmailid(),addToCart.getDishName());
        assertEquals(data.getEmailid(),addToCart.getEmailid());
    }

    @Test
    public void getAllAddToCartDetails()
    {
        addToCartRepository.save(addToCart);
        List<AddToCart> data=addToCartRepository.findAll();
        assertEquals(1,data.size());
    }

    @Test
    public void deleteFromAddToCart()
    {
        addToCartRepository.insert(addToCart);
        addToCartRepository.deleteByRestaurantNameAndDishName(addToCart.getRestaurantName(),addToCart.getDishName());
        assertEquals(Optional.empty(),addToCartRepository.findById(addToCart.getDishName()));
    }

//    @Test
//    public void testingForFailureWithSameEntriesTwice() throws DuplicateKeyException {
//        addToCartRepository.insert(addToCart);
//        assertThrows(DuplicateKeyException.class,()-> addToCartRepository.insert(addToCart));
//    }
}
