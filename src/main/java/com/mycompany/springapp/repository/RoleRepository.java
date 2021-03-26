package com.mycompany.springapp.repository;

import com.mycompany.springapp.model.RoleModel;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<RoleModel,Long> {
}
