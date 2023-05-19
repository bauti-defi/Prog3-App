package edu.ucema.marketplace.services.interfaces;

import java.util.List;

import edu.ucema.marketplace.models.Collection;

public interface ICollectionService {

    Collection getCollection(String address);

    List<Collection> getAllCollections();
    
}
