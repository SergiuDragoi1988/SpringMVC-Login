package com.example.demoSpring.data.repositories;

import com.example.demoSpring.data.DAO.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

}
