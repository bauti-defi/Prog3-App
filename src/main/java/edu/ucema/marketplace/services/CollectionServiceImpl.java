package edu.ucema.marketplace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucema.marketplace.models.Collection;
import edu.ucema.marketplace.repositories.CollectionRepository;
import edu.ucema.marketplace.services.interfaces.ICollectionService;


@Service
public class CollectionServiceImpl implements ICollectionService {

    @Autowired
    private CollectionRepository collectionRepo;

    @Override
    public Collection getCollection(String address) {
        return this.collectionRepo.findById(address).orElse(null);
    }

    @Override
    public List<Collection> getAllCollections() {
        return (List<Collection>) this.collectionRepo.findAll();
    }
    
}
