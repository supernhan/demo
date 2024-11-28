package com.devteria.demo.service;

import com.devteria.demo.dto.request.UsersCreationRequest;
import com.devteria.demo.dto.request.UsersUpdateRequest;
import com.devteria.demo.entity.Users;
import com.devteria.demo.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public Users createUser(UsersCreationRequest request){
        Users users = new Users();
        users.setUsername(request.getUsername());
        users.setPassword(request.getPassword());
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setDob(request.getDob());
        return usersRepository.save(users);

    }

    public Users updateUser(String usersId, UsersUpdateRequest request){
        Users users = getUser(usersId);
        users.setPassword(request.getPassword());
        users.setFirstName(request.getFirstName());
        users.setLastName(request.getLastName());
        users.setDob(request.getDob());
        return usersRepository.save(users);
    }

    public void deleteUser(String usersId){
        usersRepository.deleteById(usersId);
    }

    public List<Users> getUsers(){
        return usersRepository.findAll();
    }
    public Users getUser(String id){
        return usersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found "));
    }
}
