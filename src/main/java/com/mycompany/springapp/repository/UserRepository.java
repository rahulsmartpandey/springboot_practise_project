package com.mycompany.springapp.repository;

import com.mycompany.springapp.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserModel,Long> {

    UserModel findByEmailAndPassword(String email, String password);


}
