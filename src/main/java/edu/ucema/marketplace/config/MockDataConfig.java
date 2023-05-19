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

        collectionRepo.save(Constants.BORED_APE_COLLECTION);
        collectionRepo.save(Constants.COOL_CATS_COLLECTION);
        collectionRepo.save(Constants.CRYPTO_PUNKS_COLLECTION);

        System.out.println("DB mock data setup complete!");
    }
    
}
