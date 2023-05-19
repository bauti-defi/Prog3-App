package edu.ucema.marketplace.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "nft")
@IdClass(NFTCompoundKey.class)
public class NFT {

    @Id
    private String address;

    @Id
    private String tokenId;

    @Column(nullable = false, updatable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "collection_id", nullable = false, updatable = false)
    private Collection collection;

    public NFT(){}

    public NFT(String address, String tokenId, String name) {
        this.address = address;
        this.tokenId = tokenId;
        this.name = name;
    }

    // Getters and setters

    public String getAddress() {
        return address;
    }

    public String getTokenId() {
        return tokenId;
    }

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NFT nft = (NFT) o;
        return Objects.equals(address, nft.address) &&
                Objects.equals(tokenId, nft.tokenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, tokenId);
    }
}

