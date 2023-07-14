package edu.ucema.marketplace.repositories;

import org.springframework.stereotype.Repository;

import edu.ucema.marketplace.models.Collection;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface CollectionRepository extends CrudRepository<Collection, String>{

    Optional<Collection> findByAddress(String address);
    
}
