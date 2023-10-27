package com.niit.AdminProfile.service;
import com.niit.AdminProfile.model.AddToCart;
import com.niit.AdminProfile.repository.AddToCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddToCartServiceImpl implements AddToCartService
{

    @Autowired
    AddToCartRepository addToCartRepository;

    @Override
    public AddToCart addToCart(AddToCart addToCart) throws Exception {
        AddToCart add=addToCartRepository.findByUemailidAndEmailidAndDishName(addToCart.getUemailid(),addToCart.getEmailid(),addToCart.getDishName());
        if(add==null) {
            return addToCartRepository.save(addToCart);
        }
        else
        {
            throw new Exception();
        }
    }

    @Override
    public List<AddToCart> getAll(String email) {
        return addToCartRepository.findByUemailid(email);
    }

    @Override
    public boolean deleteToCart(String uemailid, String email, String dishname) {
        AddToCart add=addToCartRepository.findByUemailidAndEmailidAndDishName(uemailid,email,dishname);
        if(add==null)
        {
            return false;

        }
        else
        {
            addToCartRepository.deleteByRestaurantNameAndDishName(add.getRestaurantName(), add.getDishName());
            return true;
        }


    }
}
