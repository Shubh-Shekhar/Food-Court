package com.niit.UserProfile.repository;

import com.niit.UserProfile.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserProfileRepository extends MongoRepository<UserProfile,String> {

    Optional<UserProfile> findByEmailid(String emailid);
}
