package edu.ucema.marketplace.services.interfaces;

import edu.ucema.marketplace.models.NFT;

public interface INftService {

    NFT getNft(String address, String tokenId);
    
}
