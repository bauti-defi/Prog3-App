package edu.ucema.marketplace.models;

import java.io.Serializable;
import java.util.Objects;

public class NFTCompoundKey implements Serializable {

    private String address;
    private String tokenId;

    public NFTCompoundKey(){}

    public NFTCompoundKey(String address, String tokenId) {
        this.address = address;
        this.tokenId = tokenId;
    }

    // Getters

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
        NFTCompoundKey that = (NFTCompoundKey) o;
        return Objects.equals(address, that.address) &&
                Objects.equals(tokenId, that.tokenId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, tokenId);
    }

}
