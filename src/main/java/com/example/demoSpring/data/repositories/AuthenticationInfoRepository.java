package com.example.demoSpring.data.repositories;

import com.example.demoSpring.data.DAO.AuthenticationInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationInfoRepository extends CrudRepository<AuthenticationInfo, Integer> {


    Optional<AuthenticationInfo> findByUserName(String userName);

}
