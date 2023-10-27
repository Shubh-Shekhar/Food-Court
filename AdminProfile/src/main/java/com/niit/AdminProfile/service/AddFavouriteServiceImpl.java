package com.niit.AdminProfile.service;

import com.niit.AdminProfile.exception.DataPresentInAddToFavourite;
import com.niit.AdminProfile.model.AddFavourite;
import com.niit.AdminProfile.model.AddToCart;
import com.niit.AdminProfile.repository.AddFavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddFavouriteServiceImpl implements AddFavouriteService {

    @Autowired
    AddFavouriteRepository addFavouriteRepository;

    @Override
    public AddFavourite addToFavourite(AddFavourite addFavourite) throws DataPresentInAddToFavourite {
        AddFavourite add=addFavouriteRepository.findByUemailidAndEmailidAndDishName(addFavourite.getUemailid(),addFavourite.getEmailid(),addFavourite.getDishName());
        if(add==null) {
            return addFavouriteRepository.save(addFavourite);
        }
        else
        {
            throw new DataPresentInAddToFavourite();
        }
    }

    @Override
    public List<AddFavourite> getAll(String email) {
        return addFavouriteRepository.findByUemailid(email);
    }

    @Override
    public boolean deleteToFavourite(String uemailid, String email, String dishname) {
        AddFavourite add=addFavouriteRepository.findByUemailidAndEmailidAndDishName(uemailid,email,dishname);
        if(add==null)
        {
            return false;

        }
        else
        {
            addFavouriteRepository.deleteByRestaurantNameAndDishName(add.getRestaurantName(), add.getDishName());
            return true;
        }

    }
}