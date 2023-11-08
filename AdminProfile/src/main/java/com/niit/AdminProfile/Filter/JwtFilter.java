//package com.niit.AdminProfile.Filter;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
//@Configuration
//public class JwtFilter extends GenericFilterBean {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
//
//        String authHeader=httpServletRequest.getHeader("authorization");
//
//        if(authHeader==null || authHeader.startsWith("Bearer")){
//            throw new ServletException("Token is Missing");
//        }else{
//            String token=authHeader.substring(7);
//
//            Claims claims= Jwts.parser().setSigningKey("mykeyAdmin").parseClaimsJws(token).getBody();
//
//            System.out.println("Claims From Token:"+claims);
//
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//    }
//}
