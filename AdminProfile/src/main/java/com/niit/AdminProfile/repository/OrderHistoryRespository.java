package com.niit.AdminProfile.repository;

import com.niit.AdminProfile.model.AddFavourite;
import com.niit.AdminProfile.model.AddToCart;
import com.niit.AdminProfile.model.OrderHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderHistoryRespository extends MongoRepository<OrderHistory,String> {
    public List<OrderHistory> findByUemailid(String uemailid);
}
