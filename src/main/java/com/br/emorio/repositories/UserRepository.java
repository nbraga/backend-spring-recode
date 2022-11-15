package com.br.emorio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.emorio.entity.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
    
    User getById(Long id);
}

