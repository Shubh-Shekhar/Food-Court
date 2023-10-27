package com.niit.UserProfile.proxy;


import com.niit.UserProfile.model.Input;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "UserAuthenticationService",url = "localhost:8082")
public interface UserProfileProxy {

    @PostMapping("/user/signup")
    public ResponseEntity<?> signup(@RequestBody Input input);
}
