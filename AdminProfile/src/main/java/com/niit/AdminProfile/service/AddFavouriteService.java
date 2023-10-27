package com.niit.AdminProfile.service;

import com.niit.AdminProfile.exception.DataPresentInAddToFavourite;
import com.niit.AdminProfile.model.AddFavourite;

import java.util.List;

public interface AddFavouriteService {

    public abstract AddFavourite addToFavourite(AddFavourite addFavourite) throws DataPresentInAddToFavourite;

    public abstract List<AddFavourite> getAll(String email);


    public  abstract boolean deleteToFavourite(String uemailid, String email, String dishname);
}