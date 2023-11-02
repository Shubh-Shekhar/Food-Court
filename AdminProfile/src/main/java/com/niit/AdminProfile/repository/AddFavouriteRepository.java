
package com.niit.AdminProfile.repository;

import com.niit.AdminProfile.model.AddFavourite;
import com.niit.AdminProfile.model.AddToCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddFavouriteRepository extends MongoRepository<AddFavourite,String> {
    public List<AddFavourite> findByUemailid(String uemailid);
    public AddFavourite findByUemailidAndEmailidAndDishName(String uemailid, String emailid, String dishName);
    public AddFavourite deleteByRestaurantNameAndDishName(String restname,String dish);
}