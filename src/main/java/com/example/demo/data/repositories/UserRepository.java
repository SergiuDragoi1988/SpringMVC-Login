package com.example.demo.data.repositories;

import com.example.demo.data.DAO.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {


}
