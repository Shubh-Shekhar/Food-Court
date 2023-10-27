package com.niit.AdminProfile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Dish Already Exists Add to favourite")
public class DataPresentInAddToFavourite extends Exception{
}