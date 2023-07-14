package edu.ucema.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucema.marketplace.models.NFT;
import edu.ucema.marketplace.models.Purchase;
import edu.ucema.marketplace.models.User;
import edu.ucema.marketplace.repositories.NFTRepository;
import edu.ucema.marketplace.repositories.PurchaseRepository;
import edu.ucema.marketplace.services.interfaces.IPurchaseService;

@Service
public class PurchaseServiceImpl implements IPurchaseService{

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private NFTRepository nftRepo;

    @Override
    public void savePurchases(NFT[] nfts, User user) {
        for (NFT nft : nfts) {
            nftRepo.save(nft);
            Purchase purchase = new Purchase(nft, user);
            purchaseRepository.save(purchase);
        }
    }
    
}
