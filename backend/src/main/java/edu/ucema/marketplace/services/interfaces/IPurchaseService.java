package edu.ucema.marketplace.services.interfaces;

import edu.ucema.marketplace.models.NFT;
import edu.ucema.marketplace.models.User;

public interface IPurchaseService {

    void savePurchases(NFT[] nft, User user);
    
}
