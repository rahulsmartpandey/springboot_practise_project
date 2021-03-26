package com.mycompany.springapp.controller;

import com.mycompany.springapp.exception.BusinessException;
import com.mycompany.springapp.model.UserModel;
import com.mycompany.springapp.repository.UserRepository;
import com.mycompany.springapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public ResponseEntity<Iterable<UserModel>> getAllUsers(){
        ResponseEntity re = null;
       Iterable<UserModel> list = userService.getAllUsers();
       List<UserModel> userModelList = (ArrayList)list;

       if (userModelList.isEmpty()){
           re = new ResponseEntity(list,HttpStatus.NOT_FOUND);
       }
       else {
           re = new ResponseEntity(list, HttpStatus.OK);
       }
       return re;
    }

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(@RequestBody UserModel user){

        ResponseEntity<?> re = null;
        try {
            user = userService.registerUser(user);
            re = new ResponseEntity<UserModel>(user,HttpStatus.CREATED);
        }catch (BusinessException be){
            re = new ResponseEntity<String>(be.getMessage(), HttpStatus.FOUND);
        }

       return re;
    }
}
