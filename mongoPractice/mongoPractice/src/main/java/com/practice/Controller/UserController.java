package com.practice.Controller;


import com.practice.Entity.User;
import com.practice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("user")
    public ResponseEntity<?> getUserById(@RequestParam Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("users/page")
    public ResponseEntity<?> getAllUsers(@RequestParam Integer pageSize , @RequestParam Integer pageNo , @RequestParam String sortBy){
        return userService.getAllUsers(pageSize , pageNo , sortBy);
    }

}
