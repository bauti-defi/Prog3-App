package edu.ucema.marketplace.repositories;

import org.springframework.stereotype.Repository;

import edu.ucema.marketplace.models.User;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, String>{

    boolean existsByName(String name);
    
}
