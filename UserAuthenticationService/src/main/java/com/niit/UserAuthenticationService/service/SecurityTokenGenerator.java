package com.niit.UserAuthenticationService.service;

import com.niit.UserAuthenticationService.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    public abstract Map<String,String> generateToken(User user);
}
