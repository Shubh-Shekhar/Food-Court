package com.niit.UserAuthenticationService.service;

import com.niit.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.niit.UserAuthenticationService.exception.UserNotFoundException;
import com.niit.UserAuthenticationService.model.User;

import java.util.List;

public interface UserService {

    public abstract User signUp(User user) throws UserAlreadyExistsException;

    public abstract User logIn(String emailid,String password) throws UserNotFoundException;

    public abstract List<User> getUser();
}

