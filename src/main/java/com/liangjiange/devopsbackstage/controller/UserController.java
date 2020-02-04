package com.liangjiange.devopsbackstage.controller;

import com.liangjiange.devopsbackstage.entity.User;
import com.liangjiange.devopsbackstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getUser(@RequestParam String username) {
        User user = userService.getByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
