package edu.ucema.marketplace.models;

public class ModelFactory {

    public static NFTCompoundKey nftCompoundKey(String address, String tokenId){
        return new NFTCompoundKey(address, tokenId);
    }
    
}
