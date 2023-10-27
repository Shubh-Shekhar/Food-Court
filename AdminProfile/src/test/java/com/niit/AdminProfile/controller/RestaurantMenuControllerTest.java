package com.niit.AdminProfile.controller;

import com.niit.AdminProfile.model.RestaurantMenu;
import com.niit.AdminProfile.service.RestaurantMenuService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class RestaurantMenuControllerTest
{
    @Mock
    private RestaurantMenuService restaurantMenuService;

    @InjectMocks
    private RestaurantMenuController restaurantMenuController;

    @Autowired
    private MockMvc mockMvc;

    private RestaurantMenu restaurantMenu;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        byte [] data = bos.toByteArray();
        restaurantMenu=new RestaurantMenu("restaurant@.com","my Rest","paneer","4","450","c//data//asdf.jpg",data);
        mockMvc= MockMvcBuilders.standaloneSetup(restaurantMenuController).build();
    }
    @AfterEach
    public void distroy()
    {
        restaurantMenu=null;

    }

    @Test
    public void getMenu() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/menu/getProducts"))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void deleteDish() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/admin/menu/deletedish/restaurant@.com/paneer"))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}
