package com.niit.UserAuthenticationService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

//    @GeneratedValue(strategy= GenerationType.SEQUENCE)
//    int id;

    @Id
    String uemailid;

    String upassword,role;


}
