package edu.ucema.marketplace.services.interfaces;

import edu.ucema.marketplace.models.NFT;

public interface INFTService {

    NFT getNft(String address, String tokenId);
    
}
