package edu.ucema.marketplace.utils;

import edu.ucema.marketplace.models.NFTCompoundKey;

public class ModelFactory {

    public static NFTCompoundKey nftCompoundKey(String address, String tokenId){
        return new NFTCompoundKey(address, tokenId);
    }
    
}
