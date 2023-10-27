package com.niit.UserAuthenticationService.service;

import com.niit.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.niit.UserAuthenticationService.exception.UserNotFoundException;
import com.niit.UserAuthenticationService.model.User;
import com.niit.UserAuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public User signUp(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getUemailid()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        else {
            return userRepository.save(user);
        }

    }

    @Override
    public User logIn(String emailid,String password) throws UserNotFoundException {
        User user1=userRepository.findByUemailidAndUpassword(emailid,password);
        if(user1!=null){
            return user1;
        }
        else {
            throw new UserNotFoundException();
        }

    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }


}
