package com.niit.UserAuthenticationService.service;

import com.niit.UserAuthenticationService.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenForAdminImpl  implements SecurityTokenForAdmin{

    @Override
    public Map<String, String> generateTokenAdmin(User user) {

        String jwttoken = Jwts.builder()
                .setSubject(user.getUemailid())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"mykeyAdmin").compact();

        Map<String,String> map = new HashMap<>();
        map.put("tokenAdmin",jwttoken);
        map.put("message","Admin successfully logged in");
        map.put("role", user.getRole());
        return map;
    }
}
