package com.example.demoSpring.data.repositories;

import com.example.demoSpring.data.DAO.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository  extends CrudRepository <Address, Integer> {
}

