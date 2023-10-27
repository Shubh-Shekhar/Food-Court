package com.niit.AdminProfile.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Restaurant {

    @Id
    private String emailid;
    private String resturantName;
    private String city,pincode;
    private String rating;
    private String imageUrl;
    private byte[] resImage;

}
