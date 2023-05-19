package edu.ucema.marketplace.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private String sellerAddress;

    @Column(nullable = false, updatable = false)
    private String nftAddress;

    @Column(nullable = false, updatable = false)
    private String tokenId;

    @Column(nullable = false, updatable = true)
    private int price;

    public Listing(){}


    public Listing(String sellerAddress, String nftAddress, String tokenId, int price) {
        this.sellerAddress = sellerAddress;
        this.nftAddress = nftAddress;
        this.tokenId = tokenId;
        this.price = price;
    }


    public Long getId() {
        return id;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public String getNftAddress() {
        return nftAddress;
    }

    public String getTokenId() {
        return tokenId;
    }

    public int getPrice() {
        return price;
    }
    
}
