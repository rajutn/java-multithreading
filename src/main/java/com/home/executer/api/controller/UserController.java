package com.home.executer.api.controller;

import com.home.executer.api.entity.User;
import com.home.executer.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUsers(MultipartFile[] files){
        Arrays.stream(files).parallel().forEach(e-> {
            try {
                userService.saveUser(e);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @GetMapping(value = "/",produces = {MediaType.APPLICATION_JSON_VALUE})
    public CompletableFuture<ResponseEntity> getAllUsers(){
        return userService.getAllUsers().thenApply(ResponseEntity::ok);
    }
}
