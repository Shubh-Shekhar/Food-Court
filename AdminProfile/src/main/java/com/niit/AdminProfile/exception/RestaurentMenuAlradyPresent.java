package com.niit.AdminProfile.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Restaurent Menu Already Exists ")
public class RestaurentMenuAlradyPresent extends Throwable {
}
