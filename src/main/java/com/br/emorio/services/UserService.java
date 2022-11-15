package com.br.emorio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.emorio.entity.User;
import com.br.emorio.exceptions.UsernameAlreadyExistsException;
import com.br.emorio.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser){

        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
    
            newUser.setUsername(newUser.getUsername());
       
            newUser.setConfirmPassword("");
            return userRepository.save(newUser);

        }catch (Exception e){
            throw new UsernameAlreadyExistsException("Username"+ newUser.getUsername() + "Esse email já está cadastrado");
        }

    }



}
