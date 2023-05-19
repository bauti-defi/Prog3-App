package edu.ucema.marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ucema.marketplace.models.Collection;
import edu.ucema.marketplace.services.interfaces.ICollectionService;

@RestController
@RequestMapping(value = "/api/collections")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CollectionController {

    @Autowired
    private ICollectionService collectionService;

    @GetMapping(path = "/{address}")
    public Collection getCollection(@PathVariable String address) {
        return this.collectionService.getCollection(address);
    }
    
}
