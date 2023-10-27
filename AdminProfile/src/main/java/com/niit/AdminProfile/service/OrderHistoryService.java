package com.niit.AdminProfile.service;

import com.niit.AdminProfile.model.AddToCart;
import com.niit.AdminProfile.model.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    public abstract OrderHistory orderHistory(OrderHistory orderHistory);
    public abstract List<OrderHistory> getAll(String email);
}
