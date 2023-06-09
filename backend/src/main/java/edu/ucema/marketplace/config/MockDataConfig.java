package edu.ucema.marketplace.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.ucema.marketplace.repositories.CollectionRepository;
import edu.ucema.marketplace.repositories.NFTRepository;

@Component
public class MockDataConfig implements CommandLineRunner{

    @Autowired
    private CollectionRepository collectionRepo;

    @Autowired
    private NFTRepository nftRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Setting up DB mock data...");

        // first lets clean up
        collectionRepo.deleteAll();
        nftRepo.deleteAll();

        // now lets create some mock data
        collectionRepo.saveAll(Constants.COLLECTIONS);

        // nftRepo.saveAll(Constants.BORED_APE_NFTS);
        // nftRepo.saveAll(Constants.COOL_CAT_NFTS);
        // nftRepo.saveAll(Constants.CRYPTO_PUNK_NFTS);

        System.out.println("DB mock data setup complete!");
    }
    
}
