package com.mycompany.springapp.service;

import com.mycompany.springapp.exception.BusinessException;
import com.mycompany.springapp.model.UserModel;
import com.mycompany.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<UserModel> getAllUsers() {
        Iterable<UserModel> list = userRepository.findAll();
        return list;
    }


    public UserModel registerUser(UserModel userModel) throws BusinessException {
        UserModel userModel1 = userRepository.findByEmailAndPassword(userModel.getEmail(),userModel.getPassword());
        if (userModel1 == null) {
            userModel = userRepository.save(userModel);
        } else {
            throw new BusinessException("Email " + userModel.getEmail() + " already exists");
        }
        return userModel;

    }

    public UserModel loginUser(UserModel userModel) throws BusinessException {
        UserModel userModel1 = userRepository.findByEmailAndPassword(userModel.getEmail(), userModel.getPassword());

        if (userModel1 == null) {
            throw new BusinessException("User Not Available");
        }
        return userModel1;

    }
}
