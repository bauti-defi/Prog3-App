package edu.ucema.marketplace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.ucema.marketplace.models.Collection;
import edu.ucema.marketplace.repositories.CollectionRepository;

@Component
public class MockDataConfig implements CommandLineRunner{

    @Autowired
    private CollectionRepository collectionRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Setting up DB mock data...");

        // first lets clean up
        collectionRepo.deleteAll();

        // now lets create some mock data
        Collection boredApCollection = new Collection("0xBC4CA0EdA7647A8aB7C2061c2E118A18a936f13D", "Bored Ape Yacht Club", "The Bored Ape Yacht Club is a collection of 10,000 unique Bored Ape NFTs");
        Collection cryptoPunksCollection = new Collection("0xb47e3cd837dDF8e4c57F05d70Ab865de6e193BBB", "CryptoPunks", "CryptoPunks are 10,000 uniquely generated characters. No two are exactly alike, and each one of them can be officially owned by a single person on the Ethereum blockchain.");
        Collection coolCatsCollection = new Collection("0x1a92f7381b9f03921564a437210bb9396471050c", "Cool Cats", "Cool Cats are 9,999 randomly generated NFTs on the Ethereum blockchain.");

        collectionRepo.save(boredApCollection);
        collectionRepo.save(cryptoPunksCollection);
        collectionRepo.save(coolCatsCollection);

        System.out.println("DB mock data setup complete!");
    }
    
}
