package com.niit.UserAuthenticationService.service;

import com.niit.UserAuthenticationService.model.User;

import java.util.Map;

public interface SecurityTokenForAdmin {

    public abstract Map<String,String> generateTokenAdmin(User user);
}
