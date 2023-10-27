
package com.niit.AdminProfile.repository;

        import com.niit.AdminProfile.model.AddFavourite;
        import com.niit.AdminProfile.model.AddToCart;
        import org.springframework.data.mongodb.repository.MongoRepository;

        import java.util.List;

public interface AddFavouriteRepository extends MongoRepository<AddFavourite,String> {
//    public AddFavourite findByEmailidAndDishName(String emailid, String dishName);
    public List<AddFavourite> findByUemailid(String uemailid);
    public AddFavourite findByUemailidAndEmailidAndDishName(String uemailid, String emailid, String dishName);
    public AddFavourite deleteByRestaurantNameAndDishName(String restname,String dish);
}