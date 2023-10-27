package com.niit.UserProfile.service;

import com.niit.UserProfile.model.Input;
import com.niit.UserProfile.model.UserProfile;
import com.niit.UserProfile.proxy.UserProfileProxy;
import com.niit.UserProfile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    UserProfileProxy userProfileProxy;
    @Autowired
    UserProfileRepository userProfileRepository;



    @Override
    public UserProfile signUp(UserProfile userProfile) {
       Input input=new Input(userProfile.getEmailid(),userProfile.getPassword());
       userProfileProxy.signup(input);
        return userProfileRepository.save(userProfile);
    }
}
