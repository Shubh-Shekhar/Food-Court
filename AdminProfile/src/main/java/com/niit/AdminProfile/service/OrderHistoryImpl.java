package com.niit.AdminProfile.service;

import com.niit.AdminProfile.model.AddToCart;
import com.niit.AdminProfile.model.OrderHistory;
import com.niit.AdminProfile.repository.OrderHistoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryImpl implements OrderHistoryService{

    @Autowired
    OrderHistoryRespository orderHistoryRespository;

    @Override
    public OrderHistory orderHistory(OrderHistory orderHistory) {
        return orderHistoryRespository.save(orderHistory);
    }

    @Override
    public List<OrderHistory> getAll(String email) {
        return orderHistoryRespository.findByUemailid(email);
    }


}
