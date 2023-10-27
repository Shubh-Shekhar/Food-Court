package com.niit.AdminProfile.controller;

import com.niit.AdminProfile.model.AddFavourite;
import com.niit.AdminProfile.service.AddFavouriteService;
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
public class AddFavouriteControllerTest {

    @Mock
    private AddFavouriteService addFavouriteService;

    @InjectMocks
    private AddFavouriteController addFavouriteController;

    @Autowired
    private MockMvc mockMvc;

    private AddFavourite addFavourite;

    @BeforeEach
    public void setup() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        byte [] data = bos.toByteArray();
        addFavourite=new AddFavourite("restaurant@.com","my Rest","paneer","4","450","c//data//asdf.jpg",data,"abc@.com");
        mockMvc= MockMvcBuilders.standaloneSetup(addFavouriteController).build();
    }
    @AfterEach
    public void distroy()
    {
        addFavourite=null;

    }



    @Test
    public void get() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/addToFavourite/get/restaurant@.com"))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }
    @Test
    public void delete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/addToFavourite/delete/favourite/abc@.com/restaurant@.com/paneer"))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
    }
}
