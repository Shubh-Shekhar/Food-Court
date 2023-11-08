package com.niit.UserProfile.controller;


import com.niit.UserProfile.model.UserProfile;
import com.niit.UserProfile.repository.UserProfileRepository;
import com.niit.UserProfile.service.UserProfileService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserProfileRepository userProfileRepository;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestPart("profile") UserProfile userProfile, @RequestPart("imageFile") MultipartFile file ) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        Path currentPath = Paths.get("UserProfile");
        Path absolutePath = currentPath.toAbsolutePath();
        UserProfile profile=new UserProfile();
        profile.setPath(absolutePath + "/src/main/resources/static/");
        byte[] bytes = file.getBytes();
        Path path = Paths.get(profile.getPath() + file.getOriginalFilename());
        Files.write(path, bytes);
        UserProfile userProfile1=new UserProfile(userProfile.getName(), userProfile.getEmailid(), userProfile.getPassword(), userProfile.getAddress(), profile.getPath()+file.getOriginalFilename(), file.getOriginalFilename());
        return new ResponseEntity<>(userProfileService.signUp(userProfile1), HttpStatus.CREATED);
    }


    @GetMapping("/get/{emailid}")
    public ResponseEntity<?> getImage(@PathVariable("emailid") String emailid) throws IOException {


        final Optional<UserProfile> retrievedImage = userProfileRepository.findByEmailid(emailid);

        File f = new File(retrievedImage.get().getPath());
        FileInputStream fis = new FileInputStream(f);
        byte byteArray[] = new byte[(int)f.length()];
        fis.read(byteArray);
        String imageString = Base64.encodeBase64String(byteArray);
        String s1[]={imageString,retrievedImage.get().getEmailid(),retrievedImage.get().getName()};

        return new ResponseEntity<>(s1,HttpStatus.OK);


    }


}
