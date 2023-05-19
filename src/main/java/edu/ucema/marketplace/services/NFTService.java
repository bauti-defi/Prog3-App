package edu.ucema.marketplace.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ucema.marketplace.models.ModelFactory;
import edu.ucema.marketplace.models.NFT;
import edu.ucema.marketplace.repositories.NftRepository;
import edu.ucema.marketplace.services.interfaces.INftService;

@Service
public class NFTService implements INftService {


    @Autowired
    private NftRepository nftRepo;

    @Override
    public NFT getNft(String address, String tokenId) {
        return this.nftRepo.findById(ModelFactory.nftCompoundKey(address, tokenId)).orElse(null);
    }

    
}
