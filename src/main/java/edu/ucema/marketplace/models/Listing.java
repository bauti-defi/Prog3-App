package edu.ucema.marketplace.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "sellerAddress", nullable = false, updatable = false)
    private User seller;

    @Column(nullable = false, updatable = false)
    private String nftAddress;

    @Column(nullable = false, updatable = false)
    private String tokenId;

    @Column(nullable = false, updatable = true)
    private int price;

    public Listing(){}


    public Listing(String sellerAddress, String nftAddress, String tokenId, int price) {
        this.seller = new User(sellerAddress);
        this.nftAddress = nftAddress;
        this.tokenId = tokenId;
        this.price = price;
    }


    public Long getId() {
        return this.id;
    }

    public User getSeller() {
        return this.seller;
    }

    public String getNftAddress() {
        return nftAddress;
    }

    public String getTokenId() {
        return this.tokenId;
    }

    public int getPrice() {
        return this.price;
    }
    
}
