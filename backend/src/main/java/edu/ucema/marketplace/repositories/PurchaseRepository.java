package edu.ucema.marketplace.repositories;

import org.springframework.stereotype.Repository;

import edu.ucema.marketplace.models.Purchase;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, String>{


    
}
