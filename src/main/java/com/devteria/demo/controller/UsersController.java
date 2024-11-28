package com.devteria.demo.controller;


import com.devteria.demo.dto.request.UsersCreationRequest;
import com.devteria.demo.dto.request.UsersUpdateRequest;
import com.devteria.demo.entity.Users;
import com.devteria.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping
    Users createUser(@RequestBody UsersCreationRequest request){
        return usersService.createUser(request);
    }
    @GetMapping
    List<Users> getUsers(){
        return usersService.getUsers();
    }
    @GetMapping("/{usersId}")
    Users getUser(@PathVariable("usersId") String usersId){
        return usersService.getUser(usersId);
    }
    @PutMapping("/{usersId}")
    Users updateUser(@PathVariable String usersId, @RequestBody UsersUpdateRequest request){
        return usersService.updateUser(usersId, request);
    }
    @DeleteMapping("/{usersId}")
    String deleteUser(@PathVariable String usersId){
        usersService.deleteUser(usersId);
        return "User has been deleted";
    }
}
