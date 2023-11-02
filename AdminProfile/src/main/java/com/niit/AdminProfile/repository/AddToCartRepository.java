package com.niit.AdminProfile.repository;


import com.niit.AdminProfile.model.AddToCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AddToCartRepository extends MongoRepository<AddToCart,String>
{
    public AddToCart findByUemailidAndEmailidAndDishName(String uemailid, String emailid, String dishName);
    public List<AddToCart> findByUemailid(String uemailid);
    public AddToCart deleteByRestaurantNameAndDishName(String restname,String dish);
}
