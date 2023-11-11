package com.niit.AdminProfile;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@EnableEurekaClient
public class AdminProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminProfileApplication.class, args);
		System.out.println("====================== Admin-Service is Processing On Port 8085 !!!===========================");
	}

//	@Bean
//	public FilterRegistrationBean filterUrl(){
//		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(new JwtFilter());
//		filterRegistrationBean.addUrlPatterns("/addToFavourite/post","/addToFavourite/get/*","/addToFavourite/delete/favourite/*","/addToCart/post","/addToCart/get/*","/addToCart/delete/cart/*","/orderHistory/post","/orderHistory/get/*",
//				"/admin/addrestaurant","/admin/removerestaurant/*","/admin/getrestaurant","/admin/search/*","/admin/searchbycity/*",
//				"/admin/menu/addDetails","/admin/menu/getProducts/*","/admin/menu/getProducts","/admin/menu/deletedish/*","/admin/menu/deletedish/*","/admin/menu/searchbydishname/*");
//
//
//		return filterRegistrationBean;
//
//	}


}
