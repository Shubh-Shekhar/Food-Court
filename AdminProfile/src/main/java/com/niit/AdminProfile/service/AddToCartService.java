package com.niit.AdminProfile.service;



import com.niit.AdminProfile.model.AddToCart;

import java.util.List;

public interface AddToCartService
{
    public abstract AddToCart addToCart(AddToCart addToCart) throws Exception;

    public abstract List<AddToCart> getAll(String email);

    public  abstract boolean deleteToCart(String uemailid, String email, String dishname);
}
