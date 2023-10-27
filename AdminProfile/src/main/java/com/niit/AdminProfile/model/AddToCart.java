package com.niit.AdminProfile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class AddToCart
{
    private  String emailid;
    private String restaurantName;
    private String dishName,quantity;
    private String price;
    private String description;
    private byte[] dishImage;
    private String uemailid;
}
