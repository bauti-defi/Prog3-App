package edu.ucema.marketplace.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.ucema.marketplace.models.NFT;
import edu.ucema.marketplace.models.NFTCompoundKey;

@Repository
public interface NFTRepository extends CrudRepository<NFT, NFTCompoundKey> {

    Optional<NFT> findByAddressAndTokenId(String address, String tokenId);
    
}
