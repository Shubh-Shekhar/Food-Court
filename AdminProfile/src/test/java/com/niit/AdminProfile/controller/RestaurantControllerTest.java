package com.niit.AdminProfile.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.AdminProfile.exception.RestaurantAlreadyExistException;
import com.niit.AdminProfile.model.Restaurant;
import com.niit.AdminProfile.service.RestaurantService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RestaurantControllerTest {
    @Mock
    private RestaurantService restaurantService;

    @InjectMocks
    private RestaurantController restaurantController;

    @Autowired
    private MockMvc mockMvc;

    private Restaurant restaurant;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        byte [] data = bos.toByteArray();
        restaurant=new Restaurant("restaurant@.com","my Rest","mumbai","4000067","4.5","c//data//asdf.jpg",data);
        mockMvc= MockMvcBuilders.standaloneSetup(restaurantController).build();
    }
    @AfterEach
    public void distroy()
    {
        restaurant=null;

    }

//    @Test
//    public void saveProductDetails() throws Exception {
//        when(restaurantService.addRestaurantDetails(restaurant)).thenReturn(restaurant);
//        mockMvc.perform(
//                        post("/admin/addrestaurant")
//                                .contentType(MediaType.APPLICATION_JSON)
//                                .content(convertToJson(restaurant)))
//                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//    }

    private static String convertToJson(final Object obj){
        String result="";
        try{
            ObjectMapper mapper = new ObjectMapper();
            result=mapper.writeValueAsString(obj);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    @Test
    public void deleteProductDetails() throws Exception {
//        when(productService.addProduct(product)).thenReturn(product);
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/removerestaurant/restaurant@.com"))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}
