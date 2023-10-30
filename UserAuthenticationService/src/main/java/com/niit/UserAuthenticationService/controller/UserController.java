package com.niit.UserAuthenticationService.controller;


import com.niit.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.niit.UserAuthenticationService.exception.UserNotFoundException;
import com.niit.UserAuthenticationService.model.User;
import com.niit.UserAuthenticationService.service.SecurityTokenForAdmin;
import com.niit.UserAuthenticationService.service.SecurityTokenGenerator;
import com.niit.UserAuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    SecurityTokenGenerator securityTokenGenerator;
    @Autowired
    SecurityTokenForAdmin securityTokenForAdmin;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) throws UserAlreadyExistsException {
         user.setRole("role_user");
        return new ResponseEntity<>(userService.signUp(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) throws UserNotFoundException{
        Map<String, String> map=null;
        try{

            User result = userService.logIn(user.getUemailid(),user.getUpassword());
            if(result.getRole().equals("role_admin")){
                map=securityTokenForAdmin.generateTokenAdmin(result);
                return new ResponseEntity<>(map, HttpStatus.OK);
            }else {
                map = securityTokenGenerator.generateToken(result);
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
        }
        catch(UserNotFoundException ex){
            throw new UserNotFoundException();
        }
        catch(Exception ex){
            return new ResponseEntity<>("Other exception",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getUser(),HttpStatus.OK);
    }

}
