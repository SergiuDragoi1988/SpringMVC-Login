package com.example.demoSpring.data.repositories;

import com.example.demoSpring.data.DAO.Address;
import com.example.demoSpring.data.DAO.AuthenticationInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository  extends CrudRepository <Address, Integer> {


}

