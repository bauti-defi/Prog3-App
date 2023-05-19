package edu.ucema.marketplace.config;

import java.util.Arrays;
import java.util.List;

import edu.ucema.marketplace.models.Collection;
import edu.ucema.marketplace.models.NFT;

public class Constants {

    public static Collection BORED_APE_COLLECTION = new Collection("0xBC4CA0EdA7647A8aB7C2061c2E118A18a936f13D", "Bored Ape Yacht Club", "The Bored Ape Yacht Club is a collection of 10,000 unique Bored Ape NFTs");
    public static Collection CRYPTO_PUNKS_COLLECTION = new Collection("0xb47e3cd837dDF8e4c57F05d70Ab865de6e193BBB", "CryptoPunks", "CryptoPunks are 10,000 uniquely generated characters. No two are exactly alike, and each one of them can be officially owned by a single person on the Ethereum blockchain.");
    public static Collection COOL_CATS_COLLECTION = new Collection("0x1a92f7381b9f03921564a437210bb9396471050c", "Cool Cats", "Cool Cats are 9,999 randomly generated NFTs on the Ethereum blockchain.");

    public static NFT COOL_CAT_NFT_1 = new NFT(COOL_CATS_COLLECTION.getAddress(), "1", "Cool Cat #1");
    public static NFT COOL_CAT_NFT_2 = new NFT(COOL_CATS_COLLECTION.getAddress(), "2", "Cool Cat #2");
    public static NFT COOL_CAT_NFT_3 = new NFT(COOL_CATS_COLLECTION.getAddress(), "3", "Cool Cat #3");
    public static List<NFT> COOL_CAT_NFTS = Arrays.asList(COOL_CAT_NFT_1, COOL_CAT_NFT_2, COOL_CAT_NFT_3);

    public static NFT BORED_APE_NFT_1 = new NFT(BORED_APE_COLLECTION.getAddress(), "1", "Bored Ape #1");
    public static NFT BORED_APE_NFT_2 = new NFT(BORED_APE_COLLECTION.getAddress(), "2", "Bored Ape #2");
    public static NFT BORED_APE_NFT_3 = new NFT(BORED_APE_COLLECTION.getAddress(), "3", "Bored Ape #3");
    public static List<NFT> BORED_APE_NFTS = Arrays.asList(BORED_APE_NFT_1, BORED_APE_NFT_2, BORED_APE_NFT_3);


    public static NFT CRYPTO_PUNK_NFT_1 = new NFT(CRYPTO_PUNKS_COLLECTION.getAddress(), "1", "Crypto Punk #1");
    public static NFT CRYPTO_PUNK_NFT_2 = new NFT(CRYPTO_PUNKS_COLLECTION.getAddress(), "2", "Crypto Punk #2");
    public static NFT CRYPTO_PUNK_NFT_3 = new NFT(CRYPTO_PUNKS_COLLECTION.getAddress(), "3", "Crypto Punk #3");
    public static List<NFT> CRYPTO_PUNK_NFTS = Arrays.asList(CRYPTO_PUNK_NFT_1, CRYPTO_PUNK_NFT_2, CRYPTO_PUNK_NFT_3);

}
