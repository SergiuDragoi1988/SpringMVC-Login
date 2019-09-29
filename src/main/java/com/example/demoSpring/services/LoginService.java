package com.example.demoSpring.services;

import com.example.demoSpring.data.DAO.AuthenticationInfo;
import com.example.demoSpring.data.repositories.AuthenticationInfoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    private AuthenticationInfoRepository authenticationInfoRepository;

    public LoginService(AuthenticationInfoRepository authenticationInfoRepository){

        this.authenticationInfoRepository = authenticationInfoRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthenticationInfo ai = authenticationInfoRepository.findByUserName(s)
                .orElseThrow(()->new UsernameNotFoundException(s));
        return new CustomUserDetails(ai);


    }
}
